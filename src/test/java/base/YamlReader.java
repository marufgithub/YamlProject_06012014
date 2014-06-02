package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

//	public static FileInputStream doc = null;
//	fr = new FileInputStream(System.getProperty("user.dir")+"\\src\\FileHouse\\env.properties");
	public static String yamlFilePath=System.getProperty("user.dir")+
			"\\src\\test\\resources\\testdata\\QA_TestData.yml";
//	public static String yamlFilePath=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\url.yml";
//	public static String yamlFilePath="C:/Users/Maruf/Desktop/JunoAndJar_040614/Project_040614/OverridingOverloadingSuper/src/test/resources/resources/QA_TestData.yml";
//	\src\test\resources\testdata\QA_TestData.yml
	
//	public static String setYamlFilePath(){
//		return yamlFilePath;
//	}
	
	
	public static String getMapValue(Map <String,Object> object,String token){
		System.out.println("From getMapValue");
		String[] st = token.split("\\.");
		System.out.println("parseMap: "+parseMap(object,token).get(st[st.length - 1]).toString());
		return parseMap(object,token).get(st[st.length - 1]).toString();
	}
	
//	private static java.util.Map<java.lang.String, java.lang.Object> parseMap(
//			java.util.Map<java.lang.String, java.lang.Object> object,
//			java.lang.String token) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private static  Map<String,Object> parseMap (Map<String,Object> object,
			String token){
		System.out.println("From parseMap");
		System.out.println("token: "+token);
		if (token.contains(".")){
//			baseurl:http://www.yahoo.com
			String[] st = token.split("\\.");
			object = parseMap((Map<String,Object>) object.get(st[0]),
					token.replace(st[0] + ".",""));
		}
		System.out.println("object: "+object);
		return object;
	}
	
//	private static Map<String, Object> getYamlValues(String token){
//		Reader doc;
//		try{
//			doc = new FileReader(yamlFilePath);
//			
//		}catch(FileNotFoundException ex){
//			System.out.println("File not valid or missing");
//			ex.printStackTrace();
//			return null;
//		}
//		Yaml yaml = new Yaml();
//		Map<String,Object> object = (Map<String,Object>) yaml.load(doc);
//		return parseMap(object, token + ".");
//		return getMapValue(object, token);
//	}
	private static String getValue(String token) throws FileNotFoundException{
		System.out.println("from getValue");
		System.out.println(yamlFilePath);
		Reader doc = new FileReader(yamlFilePath);
//		InputStream doc = new FileInputStream(new File(yamlFilePath));
//		 doc = new FileInputStream(yamlFilePath);
		System.out.println("from getValue");
		Yaml yaml = new Yaml();
		Map<String,Object> object = (Map<String,Object>) yaml.load(doc);
		System.out.println("object: "+object);//object: {baseurl=http://www.yahoo.com}
		return getMapValue(object, token);
	}
	public static String getYamlValue(String token){
		try{
			return getValue(token);
		}catch(FileNotFoundException ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}
	public static String getData(String token){
		System.out.println("token:From getData: "+ token);
		return getYamlValue(token);
	}
	


}
