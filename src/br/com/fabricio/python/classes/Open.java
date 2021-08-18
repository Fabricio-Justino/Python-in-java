package br.com.fabricio.python.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

import br.com.fabricio.python.exception.OperationNotSupportedException;
import br.com.fabricio.python.exception.TypeNotSupportedException;

public class Open {

	public static enum Type {
		READER, WRITER
	}

	private char charType;

	private String path;

	private Type currentType;

	/**
	 * Open an file give by path where the default value is to read.
	 * 
	 * @param path local of archive
	 */
	public Open(String path) {
		setPath(path);
		currentType = Type.READER;
		setCharType('r');
	}
	
	/**
	 * Open an file give by path where the value is defined by char type.
	 * 
	 * @param path - local of archive
	 * @param type - is a value that definies behavior r(Read) and w(Write)
	 */
	public Open(String path, char type) {
		setPath(path);
		setCharType(type);
	}
	
	/**
	 * 
	 * @param path
	 * @param type - is a value that definies behavior
	 */
	public Open(String path, Type type) {
		setPath(path);
		setCurrentType(type);

		this.charType = (type == Type.READER) ? 'r' : 'w';
	}

	public char getChatType() {
		return charType;
	}

	public String getPath() {
		return path;
	}

	private void setCurrentType(Type type) {
		this.currentType = type;
	}

	private void setCharType(char charType) {
		if (charType == 'r' || charType == 'w') {
			this.currentType = (charType == 'r') ? Type.READER : Type.WRITER;
			this.charType = charType;
		} else {
			throw new TypeNotSupportedException();
		}
	}

	private void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * return a String with all line found in archive/file
	 * 
	 * @return String with all archive
	 * @throws FileNotFoundException
	 */
	public String readAllArchive() throws FileNotFoundException {
		isReader();

		Scanner sc = new Scanner(new File(getPath()));

		String text = "";

		while (sc.hasNextLine()) {
			String aux = sc.nextLine();
			boolean has = sc.hasNextLine();
			text += (has) ? aux + "\n" : aux;
		}

		sc.close();
		return text;
	}
	
	/**
	 * 
	 * @param iterator read line by line from the file letting the programmer do what he wants with it, by using lambda expression like list.foreach().
	 * @throws FileNotFoundException
	 */
	public void readLineByLine(Consumer<String> iterator) throws FileNotFoundException {
		isReader();

		Scanner sc = new Scanner(new File(getPath()));

		while (sc.hasNext()) {
			iterator.accept(sc.nextLine());
		}
		sc.close();
	}
	
	/**
	 * return an String with firt Line found in text
	 * 
	 * @return firt line of archive
	 * @throws FileNotFoundException
	 */
	public String readOneLine() throws FileNotFoundException {
		isReader();

		Scanner sc = new Scanner(new File(getPath()));
		String line = "";

		line = (sc.hasNextLine()) ? sc.nextLine() : "";

		sc.close();

		return line;
	}
	
	/**
	 * This method is highly recommended to csv file or like it.
	 * 
	 * @param regex expresio that will split String of archive
	 * @return A two-dimensional array with the number of rows equal to the number of lines in the archive.
	 * @throws FileNotFoundException
	 */
	public String[][] makeTable(String regex) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(getPath()));

		String r = readOneLine();

		final int ROWS = countLines();
		
		String table[][] = new String[ROWS][];
		
		int contRow = 0;
		while(sc.hasNextLine()) {
			String[] line = sc.next().split(regex);
			table[contRow] = line;
			contRow++;
		}
				
		return table;
	}
	
	/**
	 * 
	 * @return number of lines found in archive
	 * @throws FileNotFoundException
	 */
	public int countLines() throws FileNotFoundException {
		isReader();
		
		Scanner sc = new Scanner(new File(getPath()));
		
		int count = 0;
		while (sc.hasNextLine()) {
			String aux = sc.nextLine();
			if (aux.isBlank())
				throw new NullPointerException();
			count++;
		}
		
		return count;
	}
	
	/**
	 * If file exist it will be erased and write the String defined by write.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void writeLine(String write) throws IOException {
		isWriter();

		FileWriter writer = new FileWriter(new File(path));
		writer.write(write);
		writer.close();
	}
	
	/**
	 * Write the current Str in param at end of file.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void append(String write) throws IOException {
		isWriter();

		FileWriter writer = new FileWriter(new File(getPath()), true);
		writer.write(write);
		writer.close();
	}
	
	/**
	 * If file exist it will be erased and write the String defined by write.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void writeLine(Str write) throws IOException {
		isWriter();

		FileWriter writer = new FileWriter(new File(path));
		writer.write(write.valueOf());
		writer.close();
	}
	
	/**
	 * Write the current Str in param at end of file.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void append(Str write) throws IOException {
		isWriter();

		FileWriter writer = new FileWriter(new File(getPath()), true);
		writer.write(write.valueOf());
		writer.close();
	}
	
	private void isReader() {
		if (currentType != Type.READER || charType != 'r') {
			throw new OperationNotSupportedException("writer");
		}
	}

	private void isWriter() {
		if (currentType != Type.WRITER || charType != 'w') {
			throw new OperationNotSupportedException("reader");
		}
	}

}
