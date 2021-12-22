package ir.farzanehfar.session_8.e28;

import ir.farzanehfar.session_8.e27.LambdaTest;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileTest {
    final static Logger logger = Logger.getLogger(LambdaTest.class);

    public static void main(String[] args) {
        // read/write text files
        readWriteTextFiles();

        // read/write binary files
        readWriteBinaryFiles();

        // read/write object
        readWriteObject();

        nioTest();
    }

    private static void nioTest() {
        Path currentDir = Paths.get(".");
        logger.info("current directory: " + currentDir.normalize().toAbsolutePath());
        Path parentDir = Paths.get("/..");
        logger.info("parent directory: " + parentDir.normalize().toAbsolutePath());

        Path path = Paths.get("d:\\test.txt");
        try {
            Files.copy(path, Paths.get("d:\\test_copy.txt"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(path, Paths.get("d:\\test_copy2.txt"));
            Files.delete(Paths.get("d:\\test_copy2.txt"));
        } catch (IOException e) {
            logger.error(e);
        }

        // search file
        searchFile();

        // delete directory
        deleteDirectory(path);

        logger.info("list of files:");
        try {
            Files.list(Paths.get(".")).forEach(p -> logger.info(p.getFileName()));
        } catch (IOException e) {
            logger.error(e);
        }

        logger.info("show file content by lines method:");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> logger.info(s));
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void searchFile() {
        logger.info("search file in directory");
        Path rootPath = Paths.get("D:\\JavaClass");
        String fileToFind = File.separator + "FileTest.java";

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileString = file.toAbsolutePath().toString();
                    //System.out.println("pathString = " + fileString);

                    if (fileString.endsWith(fileToFind)) {
                        logger.info("file found at path: " + file.toAbsolutePath());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void deleteDirectory(Path path) {
        logger.info("delete directory");
        try {
            Files.createDirectories(Paths.get("d:\\1\\2\\3\\"));
            Files.copy(path, Paths.get("d:\\1\\2\\3\\test_copy1.txt"));
            Files.copy(path, Paths.get("d:\\1\\2\\test_copy2.txt"));
            Files.copy(path, Paths.get("d:\\1\\test_copy3.txt"));

            Files.walkFileTree(Paths.get("d:\\1"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    logger.info("delete file: " + file.toString());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    logger.info("delete dir: " + dir.toString());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void readWriteObject() {
        class Person implements Serializable {
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        List<Person> personList = Arrays.asList(
                new Person("ali", 18),
                new Person("hasan", 22),
                new Person("reza", 28));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\persons.dat"))) {
            oos.writeObject(personList);
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }

        personList = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\persons.dat"))) {
            personList = (List<Person>) ois.readObject();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        personList.stream().forEach(p -> logger.info(p));
    }

    private static void readWriteBinaryFiles() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:\\test.dat"))) {
            dos.writeDouble(12.58);
            dos.writeLong(158798745);
            dos.writeChars("this is test content!");
        } catch (IOException e) {
            logger.error(e);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("d:\\test.dat"))) {
            logger.info(dis.readDouble());
            logger.info(dis.readLong());
            StringBuilder sb = new StringBuilder();
            while (dis.available() != 0)
                sb.append(dis.readChar());
            logger.info(sb);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private static void readWriteTextFiles() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\test.txt"))) {
            bw.write(String.format("%s%n", "this is test content line 1!"));
            bw.write(String.format("%s%n", "this is test content line 2!"));
            bw.write(String.format("%s%n", "this is test content line 3!"));
        } catch (IOException e) {
            logger.error(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("d:\\test.txt"))) {
            for (String s; (s = br.readLine()) != null; )
                logger.info(s);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
