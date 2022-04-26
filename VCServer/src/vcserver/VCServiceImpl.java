/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vcserver;

import entity.role.Role_tbl;
import entity.user.User_tbl;
import entity.repository.Repository_tbl;
import entity.file.File_tbl;
import entity.file_history.FileHistory_tbl;
import entity.locked_files.LockedFiles_tbl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import service.VCService;

/**
 *
 * @author Zahra
 */
public class VCServiceImpl extends UnicastRemoteObject implements VCService {

    private EntityManagerFactory emf;
    private EntityManager em;

    private static String generateServerSideFilePath(String repositoryName, Integer fileID, Integer fileHistoryID) {
        return (DefaultRepositoryPath + "/" + repositoryName + "/" + fileID + "-" + fileHistoryID);
    }

    private static byte[] readSmallBinaryFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }

    private static void writeSmallBinaryFile(byte[] bytes, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, bytes); //creates, overwrites
    }

    public VCServiceImpl() throws RemoteException {
        try {
            emf = Persistence.createEntityManagerFactory("VCServerPU");

            em = emf.createEntityManager();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

    }

    @Override
    public List<Role_tbl> GetRoles() throws RemoteException {
        Query query = em.createNamedQuery("Role_tbl.findAll");
        List<Role_tbl> roles = (List<Role_tbl>) query.getResultList();
        em.clear();
        return roles;
    }

    @Override
    public List<Role_tbl> GetRoleByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("Role_tbl.findById");
        query.setParameter("id", id);
        List<Role_tbl> roles = (List<Role_tbl>) query.getResultList();
        em.clear();
        return roles;
    }

    @Override
    public List<Role_tbl> GetRoleByName(String name) throws RemoteException {
        Query query = em.createNamedQuery("Role_tbl.findByName");
        query.setParameter("name", name);
        List<Role_tbl> roles = (List<Role_tbl>) query.getResultList();
        em.clear();
        return roles;
    }

    @Override
    public List<User_tbl> GetUsers() throws RemoteException {
        Query query = em.createNamedQuery("User_tbl.findAll");
        List<User_tbl> users = (List<User_tbl>) query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public List<User_tbl> GetUserByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("User_tbl.findById");
        query.setParameter("id", id);
        List<User_tbl> users = (List<User_tbl>) query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public List<User_tbl> GetUserByName(String name) throws RemoteException {
        Query query = em.createNamedQuery("User_tbl.findByName");
        query.setParameter("name", name);
        List<User_tbl> users = (List<User_tbl>) query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public List<User_tbl> GetUserByPassword(String password) throws RemoteException {
        Query query = em.createNamedQuery("User_tbl.findByPassword");
        query.setParameter("password", password);
        List<User_tbl> users = (List<User_tbl>) query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public List<User_tbl> GetUserByNameAndPassword(String name, String password) throws RemoteException {
        Query query = em.createNamedQuery("User_tbl.findByNameAndPassword");
        query.setParameter("name", name);
        query.setParameter("password", password);
        List<User_tbl> users = (List<User_tbl>) query.getResultList();
        em.clear();
        return users;
    }

    @Override
    public int UpdateLoggedIn(Integer id, Short loggedIn) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("User_tbl.updateLoggedIn");
        query.setParameter("id", id);
        query.setParameter("loggedIn", loggedIn);
        int updateData = query.executeUpdate();
        tran.commit();
        em.clear();
        return updateData;
    }

    @Override
    public int UpdatePassword(Integer id, String password) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("User_tbl.updatePassword");
        query.setParameter("id", id);
        query.setParameter("password", password);
        int updateData = query.executeUpdate();
        tran.commit();
        em.clear();
        return updateData;
    }

    @Override
    public void AddNewUser(User_tbl user) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        em.persist(user);
        tran.commit();
        em.clear();
    }

    @Override
    public List<Repository_tbl> GetRepositories() throws RemoteException {
        Query query = em.createNamedQuery("Repository_tbl.findAll");
        List<Repository_tbl> repositories = (List<Repository_tbl>) query.getResultList();
        em.clear();
        return repositories;
    }

    @Override
    public List<Repository_tbl> GetRepositoryByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("Repository_tbl.findById");
        query.setParameter("id", id);
        List<Repository_tbl> repositories = (List<Repository_tbl>) query.getResultList();
        em.clear();
        return repositories;
    }

    @Override
    public List<Repository_tbl> GetRepositoryByName(String name) throws RemoteException {
        Query query = em.createNamedQuery("Repository_tbl.findByName");
        query.setParameter("name", name);
        List<Repository_tbl> repositories = (List<Repository_tbl>) query.getResultList();
        em.clear();
        return repositories;
    }

    @Override
    public List<Repository_tbl> GetRepositoryByPath(String path) throws RemoteException {
        Query query = em.createNamedQuery("Repository_tbl.findByPath");
        query.setParameter("path", path);
        List<Repository_tbl> repositories = (List<Repository_tbl>) query.getResultList();
        em.clear();
        return repositories;
    }

    @Override
    public void AddNewRepository(Repository_tbl repository) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        em.persist(repository);
        tran.commit();
        em.clear();
    }

    @Override
    public int DeleteRepository(Integer id) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("Repository_tbl.delete");
        query.setParameter("id", id);
        int deleteData = query.executeUpdate();
        tran.commit();
        em.clear();
        return deleteData;
    }

    @Override
    public boolean CreateRepositoryDir(String repository_name) throws RemoteException {
        String repository_directory = DefaultRepositoryPath + "/" + repository_name;

        return (new File(repository_directory)).mkdirs();
    }
    
    @Override
    public boolean DeleteRepositoryDir(String repository_name) throws RemoteException {
        String repository_directory = DefaultRepositoryPath + "/" + repository_name;

        return (new File(repository_directory)).delete();
    }

    @Override
    public List<File_tbl> GetFiles() throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findAll");
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public List<File_tbl> GetFileByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findById");
        query.setParameter("id", id);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public List<File_tbl> GetFileByName(String name) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findByName");
        query.setParameter("name", name);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public List<File_tbl> GetFileByLocked(Short locked) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findByLocked");
        query.setParameter("locked", locked);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public List<File_tbl> GetFileByPath(String path) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findByPath");
        query.setParameter("path", path);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public List<File_tbl> GetFileByRepositoryID(Integer repositoryId) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findByRepositoryId");
        query.setParameter("repositoryId", repositoryId);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }
    
    @Override
    public List<File_tbl> GetFileByRepositoryIDAndUserID(Integer repositoryId, Integer userId) throws RemoteException {
        Query query = em.createNamedQuery("File_tbl.findByRepositoryIdAndUserID");
        query.setParameter("repositoryId", repositoryId);
        query.setParameter("userId", userId);
        List<File_tbl> files = (List<File_tbl>) query.getResultList();
        em.clear();
        return files;
    }

    @Override
    public int UpdateLock(Integer id, Short locked) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("File_tbl.updateLock");
        query.setParameter("id", id);
        query.setParameter("locked", locked);
        int updateData = query.executeUpdate();
        tran.commit();
        em.clear();
        return updateData;
    }

    @Override
    public void AddNewFile(File_tbl file) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        em.persist(file);
        tran.commit();
        em.clear();
    }

    @Override
    public int DeleteFile(Integer id) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("File_tbl.delete");
        query.setParameter("id", id);
        int deleteData = query.executeUpdate();
        tran.commit();
        em.clear();
        return deleteData;
    }

    @Override
    public List<LockedFiles_tbl> GetLockedFiles() throws RemoteException {
        Query query = em.createNamedQuery("LockedFiles_tbl.findAll");
        List<LockedFiles_tbl> lockedFiles = (List<LockedFiles_tbl>) query.getResultList();
        em.clear();
        return lockedFiles;
    }

    @Override
    public List<LockedFiles_tbl> GetLockedFileByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("LockedFiles_tbl.findById");
        query.setParameter("id", id);
        List<LockedFiles_tbl> lockedFiles = (List<LockedFiles_tbl>) query.getResultList();
        em.clear();
        return lockedFiles;
    }

    @Override
    public List<LockedFiles_tbl> GetLockedFileByFileID(Integer fileId) throws RemoteException {
        Query query = em.createNamedQuery("LockedFiles_tbl.findByFileID");
        query.setParameter("id", fileId);
        List<LockedFiles_tbl> lockedFiles = (List<LockedFiles_tbl>) query.getResultList();
        em.clear();
        return lockedFiles;
    }

    @Override
    public List<LockedFiles_tbl> GetLockedFileByUserID(Integer userId) throws RemoteException {
        Query query = em.createNamedQuery("LockedFiles_tbl.findByUserID");
        query.setParameter("id", userId);
        List<LockedFiles_tbl> lockedFiles = (List<LockedFiles_tbl>) query.getResultList();
        em.clear();
        return lockedFiles;
    }

    @Override
    public void AddNewLockedFile(LockedFiles_tbl lockFile) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        em.persist(lockFile);
        tran.commit();
        em.clear();
    }

    @Override
    public int DeleteLockedFile(Integer id) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("LockedFiles_tbl.delete");
        query.setParameter("id", id);
        int deleteData = query.executeUpdate();
        tran.commit();
        em.clear();
        return deleteData;
    }

    @Override
    public List<FileHistory_tbl> GetFilesHistory() throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findAll");
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByID(Integer id) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findById");
        query.setParameter("id", id);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByVersion(Long version) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findByVersion");
        query.setParameter("version", version);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByDate(Date date) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findByDate");
        query.setParameter("date", date);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByComment(String comment) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findByComment");
        query.setParameter("comment", comment);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByFileID(Integer fileId) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findByFileId");
        query.setParameter("fileId", fileId);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public List<FileHistory_tbl> GetFileHistoryByFileIDAndVersion(Integer fileId, Long version) throws RemoteException {
        Query query = em.createNamedQuery("FileHistory_tbl.findByFileIdAndVersion");
        query.setParameter("fileId", fileId);
        query.setParameter("version", version);
        List<FileHistory_tbl> filesHistory = (List<FileHistory_tbl>) query.getResultList();
        em.clear();
        return filesHistory;
    }

    @Override
    public void AddNewFileHistory(FileHistory_tbl fileHistory) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        em.persist(fileHistory);
        tran.commit();
        em.clear();
    }

    @Override
    public int DeleteFileHistory(Integer id) throws RemoteException {
        EntityTransaction tran = em.getTransaction();
        tran.begin();
        Query query = em.createNamedQuery("FileHistory_tbl.delete");
        query.setParameter("id", id);
        int deleteData = query.executeUpdate();
        tran.commit();
        em.clear();
        return deleteData;
    }

    @Override
    public boolean RecieveFile(String repositoryName, Integer fileID, Integer fileHistoryID, byte[] file_content) throws RemoteException {
        String vc_full_file_path = generateServerSideFilePath(repositoryName, fileID, fileHistoryID);
        try {
            writeSmallBinaryFile(file_content, vc_full_file_path);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(VCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public byte[] SendFile(String repositoryName, Integer fileID, Integer fileHistoryID) throws RemoteException {
        String vc_full_file_path = generateServerSideFilePath(repositoryName, fileID, fileHistoryID);
        try {
            return readSmallBinaryFile(vc_full_file_path);
        } catch (IOException ex) {
            Logger.getLogger(VCServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
