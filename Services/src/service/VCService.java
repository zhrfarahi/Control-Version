/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entity.role.Role_tbl;
import entity.user.User_tbl;
import entity.repository.Repository_tbl;
import entity.file.File_tbl;
import entity.locked_files.LockedFiles_tbl;
import entity.file_history.FileHistory_tbl;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ashrafi
 */
public interface VCService extends Remote {
    public static final String DefaultRepositoryPath = "C:/VCSRepository";
    
    List<Role_tbl> GetRoles() throws RemoteException;
    List<Role_tbl> GetRoleByID(Integer id) throws RemoteException;
    List<Role_tbl> GetRoleByName(String name) throws RemoteException;
    
    List<User_tbl> GetUsers() throws RemoteException;
    List<User_tbl> GetUserByID(Integer id) throws RemoteException;
    List<User_tbl> GetUserByName(String name) throws RemoteException;
    List<User_tbl> GetUserByPassword(String password) throws RemoteException;
    List<User_tbl> GetUserByNameAndPassword(String name, String password) throws RemoteException;
    int UpdateLoggedIn(Integer id, Short loggedIn) throws RemoteException;
    int UpdatePassword(Integer id, String password) throws RemoteException;
    void AddNewUser(User_tbl user) throws RemoteException;
    
    List<Repository_tbl> GetRepositories() throws RemoteException;
    List<Repository_tbl> GetRepositoryByID(Integer id) throws RemoteException;
    List<Repository_tbl> GetRepositoryByName(String name) throws RemoteException;
    List<Repository_tbl> GetRepositoryByPath(String path) throws RemoteException;
    void AddNewRepository(Repository_tbl repository) throws RemoteException;
    int DeleteRepository(Integer id) throws RemoteException;
    boolean CreateRepositoryDir(String repository_name) throws RemoteException;
    boolean DeleteRepositoryDir(String repository_name) throws RemoteException;
    
    List<File_tbl> GetFiles() throws RemoteException;
    List<File_tbl> GetFileByID(Integer id) throws RemoteException;
    List<File_tbl> GetFileByName(String name) throws RemoteException;
    List<File_tbl> GetFileByLocked(Short locked) throws RemoteException;
    List<File_tbl> GetFileByPath(String name) throws RemoteException;
    List<File_tbl> GetFileByRepositoryID(Integer repositoryId) throws RemoteException;
    List<File_tbl> GetFileByRepositoryIDAndUserID(Integer repositoryId, Integer userId) throws RemoteException;
    int UpdateLock(Integer id, Short locked) throws RemoteException;
    void AddNewFile(File_tbl file) throws RemoteException;
    int DeleteFile(Integer id) throws RemoteException;
    
    List<LockedFiles_tbl> GetLockedFiles() throws RemoteException;
    List<LockedFiles_tbl> GetLockedFileByID(Integer id) throws RemoteException;
    List<LockedFiles_tbl> GetLockedFileByFileID(Integer fileId) throws RemoteException;
    List<LockedFiles_tbl> GetLockedFileByUserID(Integer userId) throws RemoteException;
    void AddNewLockedFile(LockedFiles_tbl lockFile) throws RemoteException;
    int DeleteLockedFile(Integer id) throws RemoteException;
    
    List<FileHistory_tbl> GetFilesHistory() throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByID(Integer id) throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByVersion(Long version) throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByDate(Date date) throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByComment(String comment) throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByFileID(Integer fileId) throws RemoteException;
    List<FileHistory_tbl> GetFileHistoryByFileIDAndVersion(Integer fileId, Long version) throws RemoteException;
    void AddNewFileHistory(FileHistory_tbl fileHistory) throws RemoteException;
    int DeleteFileHistory(Integer id) throws RemoteException;
    
    boolean RecieveFile(String repositoryName, Integer fileID, Integer fileHistoryID, byte[] file_content) throws RemoteException;
    byte[] SendFile(String repositoryName, Integer fileID, Integer fileHistoryID) throws RemoteException;
}
