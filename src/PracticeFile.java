import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class PracticeFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path p1 = Paths.get("");
		Path p2 = p1.toAbsolutePath();
		System.out.println(p2.isAbsolute());
		
		String cd = System.getProperty("user.dir");
		System.out.println(cd);
		
		Path p4 = Path.of("C:\\Users\\kchfe\\Downloads");
		//try-with-resources文、try文が終わるとflは自動的にクローズ
		try (Stream<Path> fl = Files.walk(p4,1)){
			fl.forEach(p -> System.out.println(p.getFileName().toString()));
			}catch(IOException e) {
			  System.out.println(e);
			}
		
		/*
		Path p4 = Path.of("C:\\Users\\kchfe\\Downloads\\うん\\うん.txt");
		Path p5 = Path.of("C:\\Users\\kchfe\\Downloads\\くん.txt");
		try{
			  Files.copy(p4,p5,StandardCopyOption.REPLACE_EXISTING);
			}catch(IOException e){
			  System.out.println(e);
			}
		
			Path p3 = Path.of("C:\\Users\\kchfe\\Downloads\\a.txt\\aaa\\aaa");
			try {
				Files.createDirectories(p3);
			} catch (IOException e) {
				System.out.println(e);
			}
			if (Files.notExists(p3)) {
				System.out.println("ファイルまたはディレクトリは存在しません");
			} else {
				System.out.println("ファイルまたはディレクトリは存在します");
			}
		*/
	
	}

}
