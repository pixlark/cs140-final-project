package project;

import java.util.Arrays;

public class BasicTester {
	public static void main(String[] args) {
		Machine model = new Machine(() -> System.out.println("halt called"));
		for(int i = 0; i < Memory.DATA_SIZE; i++)
			model.setData(i, 3*i);		
		System.out.println(Arrays.toString(model.getData(0,20)));
		Instruction instr = new Instruction((byte)0,0);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("NOP");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00001001,0);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("NOT");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00101000,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("LOD 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00101011,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("LOD 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00101101,3);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("LOD 3 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00110000,3);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("STO 3 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00110101,2);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("STO 2 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01010000,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("ADD 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01010011,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("ADD 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01010101,4);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("ADD 4 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01011001,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("SUB 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01011010,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("SUB 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01011100,4);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("SUB 4 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01100000,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("MUL 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01100011,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("MUL 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01100101,4);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("MUL 4 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01101001,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("DIV 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01101010,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("DIV 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01101100,4);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("DIV 4 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111001,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111010,12);
		Instruction.checkParity(instr);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111001,12);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 12 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111010,12);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 12 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111001,0);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 0 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00111010,0);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("AND 0 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00011011,5);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JUMP 5 immediate addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00011000,25);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JUMP 25 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00011101,10);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JUMP 10 indirect addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00011110,11);
		Instruction.checkParity(instr);
		model.setAccum(10);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JUMP 11 special addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100010,5);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 5 immediate addressing acc 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100001,25);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 25 direct addressing acc 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100100,10);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 10 indirect addressing acc 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100111,11);
		Instruction.checkParity(instr);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 11 special addressing acc 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100010,5);
		Instruction.checkParity(instr);
		model.setAccum(1);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 5 immediate addressing acc > 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100001,25);
		Instruction.checkParity(instr);
		model.setAccum(1);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 25 direct addressing acc > 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100100,10);
		Instruction.checkParity(instr);
		model.setAccum(1);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 10 indirect addressing acc > 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b00100111,11);
		Instruction.checkParity(instr);
		model.setAccum(1);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("JMPZ 11 special addressing acc > 0");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01000001,10);
		Instruction.checkParity(instr);
		model.setAccum(3);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("CMPL 10 direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01000001,10);
		Instruction.checkParity(instr);
		model.setData(10, -2);
		model.setAccum(0);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("CMPL 10 (set to -2) direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01001000,10);
		Instruction.checkParity(instr);
		model.setAccum(3);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("CMPZ 10 (set to -2) direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01001000,10);
		Instruction.checkParity(instr);
		model.setData(10, 2);
		model.setAccum(3);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("CMPZ 10 (set to 2) direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));

		instr = new Instruction((byte)0b01001000,10);
		Instruction.checkParity(instr);
		model.setData(10, 0);
		model.setAccum(3);
		model.ACTION.get(instr.opcode/8).accept(instr);
		System.out.println("CMPZ 10 (set to 0) direct addressing");
		System.out.println("Acc: " + model.getAccum() + ", PC: " + model.getPC());
		System.out.println(Arrays.toString(model.getData(0,20)));


		try {
			instr = new Instruction((byte)0b00000001, 0);
			Instruction.checkParity(instr);
			throw new RuntimeException("1-NOP parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("1-NOP parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00000011,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("2-NOP flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("2-NOP flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00000010,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("3-NOP parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("3-NOP parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00000101,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("4-NOP flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("4-NOP flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00000100,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("5-NOP parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("5-NOP parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00000110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("6-NOP flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("6-NOP flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00000111,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("7-NOP parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("7-NOP parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00001000,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("8-NOT parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("8-NOT parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00001010,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("9-NOT flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("9-NOT flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00001011,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("10-NOT parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("10-NOT parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00001100,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("11-NOT flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("11-NOT flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00001101,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("12-NOT parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("12-NOT parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00001111,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("13-NOT flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("13-NOT flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00001110,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("14-NOT parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("14-NOT parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00101001,12);
			Instruction.checkParity(instr);
			throw new RuntimeException("15-LOD parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("15-LOD parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00101010,12);
			Instruction.checkParity(instr);
			throw new RuntimeException("16-LOD parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("16-LOD parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00101100,3);
			Instruction.checkParity(instr);
			throw new RuntimeException("17-LOD parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("17-LOD parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00101110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("18-LOD flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("18-LOD flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00101111,0);
			Instruction.checkParity(instr);
			throw new RuntimeException("19-LOD parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("19-LOD parity check OK");
		}

		try {
			instr = new Instruction((byte)0b00110001,3);
			Instruction.checkParity(instr);
			throw new RuntimeException("20-STO parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("20-STO parity check OK");
		}
			
		try {
			instr = new Instruction((byte)0b00110100,3);
			Instruction.checkParity(instr);
			throw new RuntimeException("21-STO parity check FAILED>>>>>>>>>>>>>");
		} catch (ParityCheckException e) {
			System.out.println("21-STO parity check OK");
		}
			
		try {
			instr = new Instruction((byte)0b00110011,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("22-STO flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("22-STO flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00110110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("23-STO flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("23-STO flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01010110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("24-ADD flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("24-ADD flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01011111,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("25-SUB flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("25-SUB flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01100110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("26-MUL flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("26-MUL flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01101111,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("27-DIV flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("27-DIV flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01101010,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("28-DIV zero div immed check FAILED>>>>>>>>>>>>>");
		} catch (DivideByZeroException e) {
			System.out.println("28-DIV zero div immed check OK");
		}

		try {
			instr = new Instruction((byte)0b01101001,10);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("29-DIV zero div dir check FAILED>>>>>>>>>>>>>");
		} catch (DivideByZeroException e) {
			System.out.println("29-DIV zero div dir check OK");
		}

		model.setData(2, 10);
		try {
			instr = new Instruction((byte)0b01101100,2);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("30-DIV zero div indir check FAILED>>>>>>>>>>>>>");
		} catch (DivideByZeroException e) {
			System.out.println("30-DIV zero div indir check OK");
		}

		try {
			instr = new Instruction((byte)0b00111100,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("31-AND flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("31-AND flags check OK");
		}

		try {
			instr = new Instruction((byte)0b00111111,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("32-AND flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("32-AND flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01000010,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("33-CMPL flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("33-CMPL flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01000100,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("34-CMPL flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("34-CMPL flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01000111,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("35-CMPL flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("35-CMPL flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01001011,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("36-CMPZ flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("36-CMPZ flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01001101,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("37-CMPZ flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("37-CMPZ flags check OK");
		}

		try {
			instr = new Instruction((byte)0b01001110,0);
			Instruction.checkParity(instr);
			model.ACTION.get(instr.opcode/8).accept(instr);
			throw new RuntimeException("38-CMPZ flag check FAILED>>>>>>>>>>>>>");
		} catch (IllegalInstructionException e) {
			System.out.println("38-CMPZ flags check OK");
		}
	}
}
