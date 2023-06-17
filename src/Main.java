import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Doctor{
    String id;
    String nombre;
    String especialidad;
    public Doctor(String id, String nom, String esp){
        this.id = id;
        this.nombre = nom;
        this.especialidad = esp;
    }
}
class Paciente{
    String id;
    String nombre;
    public Paciente(String id, String nom){
        this.id = id;
        this.nombre = nom;
    }
}
class Cita{
    String doctor;
    String paciente;
    public Cita(String doc, String pac){
        this.doctor = doc;
        this.paciente = pac;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        String opcion = "";
        String resp   = "";
        String archDoctores  = "src/db/doctores.txt";
        String archPacientes = "src/db/pacientes.txt";
        BufferedWriter bw = null;
        BufferedWriter brGuardar = new BufferedWriter(new FileWriter(archDoctores));
        BufferedWriter bwGuardarPacientes = new BufferedWriter(new FileWriter(archPacientes));


        ArrayList<Doctor> listaDoctores    = new ArrayList<Doctor>();
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
        ArrayList<Cita> listaCitas = new ArrayList<Cita>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Bienvenido a la Administración de citas");
        System.out.println("Elige una opción:");

        do {
            System.out.println("1- Dar de alta un doctor\n2- Dar de alta un paciente\n3- Crear cita\n");
            opcion = br.readLine();
            switch( opcion ) {
                case "1":
                    System.out.println("Escribe el id único del doctor:");
                    String id = br.readLine();
                    System.out.println("Escribe el nombre del doctor:");
                    String nom = br.readLine();
                    System.out.println("Escribe la especialidad del doctor:");
                    String esp = br.readLine();

                    Doctor doc = new Doctor(id,nom,esp);
                    listaDoctores.add(doc);
                    try {
                        brGuardar.write(id+"-"+nom+"-"+esp+"\n");
                    } catch (IOException e){
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        brGuardar.flush();
                    }
                    break;
                case "2":
                    System.out.println("Escribe el id único del Paciente:");
                    String idP = br.readLine();
                    System.out.println("Escribe el nombre del Paciente:");
                    String nomP = br.readLine();

                    Paciente paci = new Paciente(idP,nomP);
                    listaPacientes.add(paci);
                    try {
                        bwGuardarPacientes.write(idP+"-"+nomP+"\n");
                    } catch (IOException e){
                        System.out.println("Error: " + e.getMessage());
                    } finally {
                        bwGuardarPacientes.flush();
                    }
                    break;
                case "3":
                    System.out.println("Con que doctor desea atenderse?:");
                    System.out.println("Escriba el id del doctor:");
                    String idD = br.readLine();
                    System.out.println("Escriba el nombre del doctor:");
                    String nombreD = br.readLine();
                    System.out.println("Escriba la especialidad del doctor:");
                    String espD = br.readLine();
                    String doctorCita = idD+"-"+nombreD+""+espD;

                    if ( !listaDoctores.contains(doctorCita) ){
                        System.out.println("El doctor que escribio no está registrado.");
                    } else{
                        System.out.println("Quien desea atenderse?:");
                        System.out.println("Escriba el id del paciente:");
                        String idPa = br.readLine();
                        System.out.println("Escriba el nombre del paciente:");
                        String nombreP = br.readLine();
                        String pacCita = idPa+"-"+nombreP;
                        if ( !listaPacientes.contains(pacCita) ){
                            System.out.println("El paciente que escribio no está registrado.");
                        } else {
                            Cita citaAgendada = new Cita(doctorCita, pacCita);
                            listaCitas.add(citaAgendada);
                        }
                    }
                    break;
                case "4":
                    break;
                default:
                    System.out.println("La opción elegida no es válida.");
                    break;
            }
            System.out.println("Deseas ejecutar otra acción? (S/s para mostrar menú nuevamente o presiona cualquier otra tecla para salir)");
            resp = br.readLine();
        } while( resp.equals("S") || resp.equals("s") );



//        //ASEGURO QUE INICIEN VACIOS
//        File fileOriginal = new File(archOriginal);
//        fileOriginal.delete();
//        File fileCopia = new File(archCopia);
//        fileCopia.delete();
//        //VUELVO A CREAR LOS ARCHIVOS
//        File fileOriginalDesp = new File(archOriginal);
//        File fileCopiaDesp    = new File(archCopia);
//        if (!fileOriginalDesp.exists()){
//            fileOriginalDesp.createNewFile();
//            fileCopiaDesp.createNewFile();
//        }

//        BufferedReader br1 = null;
//        BufferedReader br2 = null;
//
//        try {
//            String line;
//
//            while((line = br1.readLine()) != null){
//                System.out.println(line);
//                bw.write(line + "\n");
//            }
//            bw.flush();
//
//            System.out.println("=============COPIAR==============");
//            br2 = new BufferedReader(new FileReader(archCopia));
//            while((line = br2.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch(IOException e){
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        System.out.println("IM IN!");
//
//        try (PrintWriter pw = new PrintWriter(archCopia)){
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}