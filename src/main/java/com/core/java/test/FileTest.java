package com.core.java.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class FileTest {
    public static void main(String[] args) throws IOException {
        changeCreationDate("D:\\accosa\\accosa_pg\\files\\base2\\outgoing\\pg_16479914\\2023\\06");
        //deleteAllFilesOlderThanXDays("D:\\Vinod\\Testing",1);
//        deleteParentFolder(Arrays.asList(new File("D:\\Vinod\\Testing\\00\\New Text Document (2).txt")));
    }

    private static void changeCreationDate(String folderPath) {
        File folder = new File(folderPath);
        Arrays.stream(folder.listFiles()).forEach( file -> {
            Path path = Paths.get(file.toURI());
            System.out.println(path);
            try {
                Calendar c = Calendar.getInstance();
                c.set(2023, Calendar.JUNE, 07);
                Files.setAttribute(path, "creationTime", FileTime.fromMillis(c.getTimeInMillis()));
                System.out.println("Changed date");
            } catch (IOException e) {
                System.err.println("Cannot change the creation time. " + e);
            }
        });
    }

    private static void deleteAllFilesOlderThanXDays(String folderPath, int noOfDays){
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(30);
        String mm = DateTimeFormatter.ofPattern("MM").format(localDateTime);
        System.out.println("Month is"+mm);

        File monthFolder = new File(folderPath+"/"+mm);
        Arrays.stream(monthFolder.listFiles()).forEach(file -> {
            BasicFileAttributes attr = null;
            try {
                attr = Files.readAttributes(Path.of(file.toURI()), BasicFileAttributes.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            FileTime creationTime = attr.creationTime();
            String formatted = getFormatted(creationTime);
            System.out.println(formatted);
            if(formatted.equals(DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now().minusDays(1)))){
                try {
                    Files.delete(Path.of(file.toURI()));
                    System.out.println("deleted successfully");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private static String getFormatted(FileTime creationTime) {
        return DateTimeFormatter.ofPattern("dd").format(creationTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    private static void deleteParentFolder(List<File> listOfFilesToDelete) {
        File parentPath = getParentPath(listOfFilesToDelete);
        for (File file : listOfFilesToDelete) {
            try {
                Files.delete(file.toPath());
                System.out.println("deleted successfully" + file);
            } catch (IOException e) {
                System.out.println("Could not delete the file"+e);
            }
        }
        if(parentPath.listFiles().length ==0 ){
            System.out.println("No Files in the parent folder:{}, deleting parent folder"+parentPath);
            try {
                Files.delete(parentPath.toPath());
                System.out.println("Deleted parent path"+parentPath);
            } catch (IOException e) {
                System.out.println("Could not delete the parent file"+e);
            }
        }

    }

    private static File getParentPath(List<File> listOfFilesToDelete) {
        if(listOfFilesToDelete.isEmpty()) return null;
        return new File(listOfFilesToDelete.get(0).getParent());
    }
}
