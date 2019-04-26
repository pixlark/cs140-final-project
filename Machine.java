package lab11;

import static lab11.Instruction.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Machine {
	private class CPU {
		private int accum;
		private int pc;
	}
	public final Map<Integer, Consumer<Instruction>> ACTION = new TreeMap<>();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private boolean withGUI = false;
	private HaltCallback callBack;

	public Machine(HaltCallback callBack)
	{
		this.callBack = callBack;

		ACTION.put(OPCODES.get("ADD"), instr -> {
				int flags = instr.opcode & 6;
				if (flags == 0) {
					cpu.accum += memory.getData(instr.arg);
				} else if (flags == 2) {
					cpu.accum += instr.arg;
				} else if (flags == 4) {
					cpu.accum += memory.getData(memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("NOP"), instr -> {
				int flags = instr.opcode & 6;
				if(flags != 0) {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("HALT"), instr -> {
				int flags = instr.opcode & 6;
				if(flags != 0) {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				halt();
			});

		ACTION.put(OPCODES.get("JUMP"), instr -> {
				int flags = instr.opcode & 6;

				if (flags == 0) {
					cpu.pc += instr.arg;
				} else if (flags == 2) {
					cpu.pc = instr.arg;
				} else if (flags == 4) {
					cpu.pc += memory.getData(instr.arg);
				} else {
					cpu.pc = memory.getData(instr.arg);
				}
			});

		ACTION.put(OPCODES.get("JMPZ"), instr -> {
				int flags = instr.opcode & 6;

				if (cpu.accum != 0) {
					cpu.accum++;
					return;
				}

				if (flags == 0) {
					cpu.pc += instr.arg;
				} else if (flags == 2) {
					cpu.pc = instr.arg;
				} else if (flags == 4) {
					cpu.pc += memory.getData(instr.arg);
				} else {
					cpu.pc = memory.getData(instr.arg);
				}
			});

		ACTION.put(OPCODES.get("LOD"), instr -> {
				int flags = instr.opcode & 6;

				if (flags == 0) {
					cpu.accum = memory.getData(instr.arg);
				} else if (flags == 2) {
					cpu.accum = instr.arg;
				} else if (flags == 4) {
					cpu.accum = memory.getData(memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}

			});

		ACTION.put(OPCODES.get("STO"), instr -> {
				int flags = instr.opcode & 6;
				
				if (flags == 0) {
					memory.setData(instr.arg, cpu.accum);
				} else if (flags == 4) {
					memory.setData(cpu.accum, memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				cpu.pc++;
			});
		
		ACTION.put(OPCODES.get("NOT"), instr -> {
				int flags = instr.opcode & 6;
				if(flags != 0) {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}

				if (cpu.accum == 0) {
					cpu.accum = 1;
				} else {
					cpu.accum = 0;
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("AND"), instr -> {
				int flags = instr.opcode & 6;

				if (flags == 0 || flags == 2) {
					if (memory.getData(instr.arg) != 0 && cpu.accum != 0) {
						cpu.accum = 1;
					} else {
						cpu.accum = 0;
					}
					cpu.pc++;
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
			});


		ACTION.put(OPCODES.get("CMPL"), instr -> {
				int flags = instr.opcode & 6;

				if (flags != 0) {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}

				if (memory.getData(instr.arg) < 0) {
					cpu.accum = 1;
				} else {
					cpu.accum = 0;
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("CMPZ"), instr -> {
				int flags = instr.opcode & 6;

				if (flags != 0) {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}

				if (memory.getData(instr.arg) == 0) {
					cpu.accum = 1;
				} else {
					cpu.accum = 0;
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("SUB"), instr -> {
				int flags = instr.opcode & 6;
				if (flags == 0) {
					cpu.accum -= memory.getData(instr.arg);
				} else if (flags == 2) {
					cpu.accum -= instr.arg;
				} else if (flags == 4) {
					cpu.accum -= memory.getData(memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("MUL"), instr -> {
				int flags = instr.opcode & 6;
				if (flags == 0) {
					cpu.accum *= memory.getData(instr.arg);
				} else if (flags == 2) {
					cpu.accum *= instr.arg;
				} else if (flags == 4) {
					cpu.accum *= memory.getData(memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				cpu.pc++;
			});

		ACTION.put(OPCODES.get("DIV"), instr -> {
				int flags = instr.opcode & 6;
				int div;
				if (flags == 0) {
					div = memory.getData(instr.arg);
				} else if (flags == 2) {
					div = instr.arg;
				} else if (flags == 4) {
					div = memory.getData(memory.getData(instr.arg));
				} else {
					String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
					throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
				}
				if (div == 0) {
					throw new DivideByZeroException("Divison by zero");
				}
				cpu.accum /= div;
				cpu.pc++;
			});
	}
			
	public int[] getData() {
		return memory.getData();
	}
	public int getData(int i){
		return memory.getData(i);
	}
	public int[] getData(int i, int j){
		return memory.getData(i, j);
	}
	public int getPC() {
		return cpu.pc;
	}
	public int getAccum() {
		return cpu.accum;
	}
	public void setData(int i, int j) {
		memory.setData(i, j);		
	}
	public void setAccum(int i) {
		cpu.accum = i;
	}
	public void setPC(int i) {
		cpu.pc = i;
	}
	public void halt()
	{
		callBack.halt();
	}
}
