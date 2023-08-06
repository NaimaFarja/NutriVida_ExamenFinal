package ar.edu.unju.fi.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Componente encargado de la gestión de subida, carga y eliminación de archivos, como imágenes.
 */

@Component
public class UploadFile {
	
	/**
     * Atributo constante que determina la carpeta donde se almacenan los archivos subidos.
     */
	private final static String UPLOADS_FOLDER = "src/main/resources/static/uploads";
	
	/**
     * Obtiene la ruta absoluta de un archivo en la carpeta de subidas.
     * @param filename Nombre del archivo.
     * @return Ruta absoluta del archivo.
     */
	public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }
	
	/**
     * Carga un recurso (archivo) a partir de su nombre de archivo.
     * @param filename Nombre del archivo a cargar.
     * @return Objeto Resource que representa el archivo.
     * @throws MalformedURLException Si la URL del recurso es inválida.
     */
	public Resource load(String filename) throws MalformedURLException {
        Path path = getPath(filename);
        Resource resource = new UrlResource(path.toUri());
        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("Error en Resource load: " + path.toString());
        }
        return resource;
	}
	
	/**
     * Guarda una copia del archivo subido en la carpeta de subidas.
     * @param file Archivo a ser guardado.
     * @return Nombre único del archivo guardado.
     * @throws IOException Si ocurre un error durante la operación de copia.
     */
	public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path rootPath = getPath(uniqueFilename);
        Files.copy(file.getInputStream(), rootPath);
        return uniqueFilename;
    }
	 
	/**
     * Borra un archivo de la carpeta de subidas.
     * @param filename Nombre del archivo a ser eliminado.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
	public boolean delete(String filename) {
        Path rootPath = getPath(filename);
        File file = rootPath.toFile();
        if (file.exists() && file.canRead()) {
            if (file.delete()) {
                return true;
            }
        }
        return false;
    }
}
