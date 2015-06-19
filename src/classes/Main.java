package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csvio.CSVAppointmentReader;
import csvio.CSVAppointmentWriter;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class Main {

	public static void main(String[] args) {
		try {
			//Schreiben
			//Einzelner Termin
			Appointment termin = new Appointment("12/06/1996", "Test-Termin", "12:00", "18:00", "Test", "Hoffentlich klappt's");
//			System.out.println("Dies ist der erstellte Termin:\n" + termin);
			
			CSVAppointmentWriter writer = new CSVAppointmentWriter();
			writer.writeAppointment(termin, "Termin", "::");
			
			//Collection
			List<Appointment> collection = new ArrayList();
			for(int i = 0; i < 3; i++) {
				collection.add(termin);
			}
			writer.writeAppointment(collection, "TerminCollection", "::");
			
			//Lesen
			CSVAppointmentReader reader = new CSVAppointmentReader();
			collection = reader.readAppointment("TerminCollection", "::");
			System.out.println(collection);
			
			
		} catch (FormatException | WertebereichException | ZeitenKollisionException | StringIsEmptyException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
