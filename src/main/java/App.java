package Tema5.Tema5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App {

	private static DateTime start;
	private static DateTime end;
	private static ArrayList<MonitoredData> monitorizare = new ArrayList<MonitoredData>();

	public static void main(String[] args) {
		String fileName = "Activities.txt";
		DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(linie -> {
				String[] impartire = linie.split("\t\t");
				start = format.parseDateTime(impartire[0]);
				end = format.parseDateTime(impartire[1]);
				String activitate = impartire[2];
				MonitoredData result = new MonitoredData(start, end, activitate);
				monitorizare.add(result);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		monitorizare.forEach(System.out::println);

		System.out.println("");
		System.out.println("");
		System.out.println("");


		Map<String, Long> contorizareNumarDeAparitii = monitorizare.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivities, Collectors.counting()));
		for (java.util.Map.Entry<String, Long> m : contorizareNumarDeAparitii.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		System.out.println("");
		System.out.println("");
		System.out.println("");

		Map<Object, Map<String, Long>> eachActivity = monitorizare.stream()
				.collect(Collectors.groupingBy(zi -> zi.getStart().getDayOfYear(),
						Collectors.groupingBy(MonitoredData::getActivities, Collectors.counting())));

		for (java.util.Map.Entry<Object, Map<String, Long>> afisare : eachActivity.entrySet()) {
			System.out.println(afisare.getKey() + " " + afisare.getValue());
		}
		/*Map<String, Long> activity = monitorizare.stream().map(data -> data.getStart() + " " + data.getActivities())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

		
	}
}
