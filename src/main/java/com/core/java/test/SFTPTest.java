package com.core.java.test;

import com.jcraft.jsch.*;

import java.io.IOException;

public class SFTPTest {
    private static final String user="AXISBKWIBMOTST";
    private static final String password = "D#456h$91";
    private static final String host="fsgateway.americanexpress.com";
    private static final int port= 22;

    public static void main(String[] args) {
        try {
            sftpFilePush("D:\\New Requirements\\Hash & Enc reports\\TTUM Test\\AXISBKWIBMOTST.SPOIG",
                    "/inbox/AXISBKWIBMOTST.SPOIG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean sftpFilePush(String srcFile, String fileDestination) throws Exception {
        JSch jsch = new JSch();
        Session session;
            session = jsch.getSession(user, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
//            session.setProxy(new ProxyHTTP("192.168.109.47", 3128));
            session.connect();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            channelSftp.put(srcFile,fileDestination);
            /*boolean directoryExists = directoryExistsCheck(channelSftp, parentPath);
            if (directoryExists) {
                LOGGER.info("Parent Directory exists");
                channelSftp.cd(parentPath);
                boolean reportFolderExists = directoryExistsCheck(channelSftp, fileDestination);
                if (reportFolderExists) {
                    channelSftp.put(srcFile, fileDestination);
                    deleteSourceFile(srcFile);
                    LOGGER.info("File Transfered Successfully");
                } else {
                    String[] folders = fileDestination.split("/");
                    for (String newFolder : folders) {
                        boolean folderExists = directoryExistsCheck(channelSftp, newFolder);
                        if (!folderExists) {
                            channelSftp.mkdir(newFolder);
                        }
                        channelSftp.cd(newFolder);
                    }
                    channelSftp.put(srcFile, parentPath + fileDestination);
                    deleteSourceFile(srcFile);
                    LOGGER.info("File Transferred Successfully");
                }
            }*/
            channelSftp.disconnect();
            session.disconnect();
            System.out.println("File Transfer-Ends");
        return true;
    }
}
