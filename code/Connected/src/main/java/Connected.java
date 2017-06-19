import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.bgc.*;

public class Connected {

    public static void main(String[] args) throws Exception {

        if(args.length != 3){
            throw new Exception("<File> <City1> <City2> arguments are required");
        }
        String file = args[0];
        String city1 = args[1].trim().toUpperCase();
        String city2 = args[2].trim().toUpperCase();

        if(!new File(file).exists()){
            throw new Exception( file + "- does not exist");
        }

        CityConnections connections = new CityConnections();
        List<String> lines = Files.readAllLines(Paths.get(file),
                Charset.defaultCharset());

        lines.forEach(p -> {
            String[] cities = p.split(",");
            connections.addCityConnection(cities[0].trim().toUpperCase(), cities[1].trim().toUpperCase());
        });

        System.out.println(connections.isConnected(city1, city2)?"Yes":"No");
    }
}
