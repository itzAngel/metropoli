package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {
	Cloudinary cloudinary;
	
	private Map<String,String> valuesMap = new HashMap<>();
	
	public CloudinaryService() {
		valuesMap.put("cloud_name", "dgktpe2rj");
		valuesMap.put("api_key", "232633335377753");
		valuesMap.put("api_secret", "XsNI97FhYFMz45qbxuNJqG1RJ2U");
		cloudinary=new Cloudinary(valuesMap);
	}
	public Map uploadVideo(MultipartFile multipartfile) throws IOException {
		File file = convert(multipartfile);
		Map result = cloudinary.uploader().uploadLarge(file, ObjectUtils.asMap("resource_type", "video"));
		return result;
	}
	
	public Map deleteVideo(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.asMap("resource_type", "video"));
		return result;
	}
	
	public Map uploadDocumento(MultipartFile multipartfile) throws IOException {
		File file = convert(multipartfile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap("resource_type", "raw"));
		return result;
	}
	
	public Map deleteDocumento(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.asMap("resource_type", "raw"));
		return result;
	}
	
	public Map upload(MultipartFile multipartfile) throws IOException {
		File file = convert(multipartfile);
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return result;
	}
	
	public Map delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return result;
	}
	
	private File convert(MultipartFile multipartfile) throws IOException {
		File file = new File(multipartfile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartfile.getBytes());
		fo.close();
		return file;
	}
}
