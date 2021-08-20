package br.com.fabricio.python.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	public Open(Str path, Type type) {
		setPath(path.valueOf());
		setCurrentType(type);

		this.charType = (type == Type.READER) ? 'r' : 'w';
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

	/**
	 * Open an file give by path where the default value is to read.
	 * 
	 * @param path local of archive
	 */
	public Open(Str path) {
		setPath(path.valueOf());
		currentType = Type.READER;
		setCharType('r');
	}

	/**
	 * Open an file give by path where the value is defined by char type.
	 * 
	 * @param path - local of archive
	 * @param type - is a value that definies behavior r(Read) and w(Write)
	 */
	public Open(Str path, char type) {
		setPath(path.valueOf());
		setCharType(type);
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

		try (Scanner sc = new Scanner(new File(getPath()))) {

			String text = "";

			while (sc.hasNextLine()) {
				String aux = sc.nextLine();
				boolean has = sc.hasNextLine();
				text += (has) ? aux + "\n" : aux;
			}

			return text;
		}
	}

	/**
	 * 
	 * @param iterator read line by line from the file letting the programmer do
	 *                 what he wants with it, by using lambda expression like
	 *                 list.foreach().
	 * @throws FileNotFoundException
	 */
	public void readLineByLine(Consumer<String> iterator) throws FileNotFoundException {
		isReader();

		try (Scanner sc = new Scanner(new File(getPath()))) {

			while (sc.hasNext()) {
				iterator.accept(sc.nextLine());
			}
		}

	}

	/**
	 * return an String with firt Line found in text
	 * 
	 * @return firt line of archive
	 * @throws FileNotFoundException
	 */
	public String readOneLine() throws FileNotFoundException {
		isReader();

		try (Scanner sc = new Scanner(new File(getPath()))) {

			String line = "";

			line = (sc.hasNextLine()) ? sc.nextLine() : "";

			return line;
		}
	}

	/**
	 * This method is highly recommended to csv file or like it.
	 * 
	 * @param regex expresio that will split String of archive
	 * @return A two-dimensional array with the number of rows equal to the number
	 *         of lines in the archive.
	 * @throws FileNotFoundException
	 */
	public String[][] makeTable(String regex) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(getPath()))) {

			String r = readOneLine();

			final int ROWS = countLines();

			String table[][] = new String[ROWS][];

			int contRow = 0;
			while (sc.hasNextLine()) {
				String[] line = sc.next().split(regex);
				table[contRow] = line;
				contRow++;
			}

			return table;
		}
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

		try (FileWriter writer = new FileWriter(new File(path))) {
			writer.write(write);
		}
	}

	/**
	 * Write the current Str in param at end of file.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void append(String write) throws IOException {
		isWriter();

		try (FileWriter writer = new FileWriter(new File(getPath()), true)) {
			writer.write(write);
		}
	}

	/**
	 * If file exist it will be erased and write the String defined by write.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void writeLine(Str write) throws IOException {
		isWriter();

		try (FileWriter writer = new FileWriter(new File(path))) {
			writer.write(write.valueOf());
		}
	}

	/**
	 * Write the current Str in param at end of file.
	 * 
	 * @param write word that will be writer in file
	 * @throws IOException
	 */
	public void append(Str write) throws IOException {
		isWriter();

		try (FileWriter writer = new FileWriter(new File(getPath()), true)) {
			writer.write(write.valueOf());
		}
	}

	/**
	 * save object in an File defined by path
	 * 
	 * 
	 * @param obj element that will be saved
	 * @throws IOException
	 */
	public void saveObject(Object obj) throws IOException {
		isWriter();
		try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(new File(getPath())))) {
			save.writeObject(obj);
		}
	}

	/**
	 * persistence of data. loading data in file
	 * 
	 * @return Object read in file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object readObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		isReader();

		try (ObjectInputStream save = new ObjectInputStream(new FileInputStream(new File(getPath())))) {
			Object obj = save.readObject();
			return obj;
		}
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
