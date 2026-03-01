package model;


  //Data model representing a hidden file entry.

public class Data {

    private final int id;
    private final String fileName;
    private final String path;
    private final String email ;

    public Data(int id, String fileName, String path, String email) {

        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path cannot be empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        this.id = id;
        this.fileName = fileName;
        this.path = path;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Data{id=" + id +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}