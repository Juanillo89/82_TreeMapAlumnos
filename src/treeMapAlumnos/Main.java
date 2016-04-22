package treeMapAlumnos;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import ejercicio59.Alumno;

public class Main
{
	private static TreeMap<Integer, Alumno> tMAlumnos;
	private static Scanner sc;
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		tMAlumnos = new TreeMap<Integer, Alumno>();
		String opcion = "";
		do
		{
			mostrarMenu();
			System.out.print("Opción: ");
			opcion = sc.nextLine();
			switch(opcion)
			{
				case "1":
					listarAlumnos(tMAlumnos);
					break;
				case "2":
					introducirAlumno(tMAlumnos);
					break;
				case "3":
					introducirNota(tMAlumnos);
					break;
				case "4":
					eliminarAlumno(tMAlumnos);
					break;
				case "5":
					eliminarTodos(tMAlumnos);
					break;
				case "6":
					System.out.println("Hasta luego.");
					break;
				default:
					System.out.println("Opción incorrecta.");
					break;
			}

		}
		while(!opcion.equals("6"));
	}

	private static void mostrarMenu()
	{
		System.out.println("\nOpciones:" +
			"\n1.- Listar alumnos." +
			"\n2.- Introducir alumno." +
			"\n3.- Introducir nota de alumno." +
			"\n4.- Eliminar alumno." +
			"\n5.- Eliminar todos." +
			"\n6.- Salir.");
	}

	private static void listarAlumnos(TreeMap<Integer, Alumno> tMAlumnos)
	{
		if(!tMAlumnos.isEmpty())
		{
			Iterator<Integer> iterator = tMAlumnos.keySet().iterator();
			System.out.println("Expediente\tNombre\tPrimera ev.\tSegunda ev.\tTercera ev." +
				"\n--------------------------------------------------------------------");
			while(iterator.hasNext())
			{
				int key = iterator.next();
				System.out.println(key + "\t\t" + tMAlumnos.get(key).getNombre() + "\t" + tMAlumnos.get(key).getNota(1) + "\t\t" +
						tMAlumnos.get(key).getNota(2) + "\t\t" + tMAlumnos.get(key).getNota(3));
			}
		}
	}

	private static void introducirAlumno(TreeMap<Integer, Alumno> tMAlumnos)
	{
		int exp = 0;
		while(exp == 0)
		{
			try
			{
				System.out.print("Número de expediente: ");
				exp = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Debe ser un número entero.");
			}
		}
		if(tMAlumnos.containsKey(exp))
		{
			System.out.println("Ya existe.");
		}
		else
		{
			System.out.println("Nombre: ");
			tMAlumnos.put(exp, new Alumno(sc.nextLine()));
		}
	}

	private static void introducirNota(TreeMap<Integer, Alumno> tMAlumnos)
	{
		int exp = 0;
		while(exp == 0)
		{
			try
			{
				System.out.print("Número de expediente: ");
				exp = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Debe ser un número entero.");
			}
		}
		if(!tMAlumnos.containsKey(exp))
		{
			System.out.println("No existe.");
		}
		else
		{
			System.out.print("Evaluación: ");
			int evaluacion = Integer.parseInt(sc.nextLine());
			if(evaluacion < 1 || evaluacion > 3)
			{
				System.out.println("Evaluación no válida.");
			}
			else
			{
				System.out.print("Nota: ");
				double nota = Double.parseDouble(sc.nextLine());
				Alumno alumno = tMAlumnos.get(exp);
				if(!alumno.ponerNota(evaluacion, nota))
				{
					System.out.println("Nota no válida.");
				}
			}
		}
	}

	private static void eliminarTodos(TreeMap<Integer, Alumno> tMAlumnos)
	{
		tMAlumnos.clear();
	}

	private static void eliminarAlumno(TreeMap<Integer, Alumno> tMAlumnos)
	{
		int exp = 0;
		while(exp == 0)
		{
			try
			{
				System.out.print("Número de expediente: ");
				exp = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Debe ser un número entero.");
			}
		}
		if(tMAlumnos.remove(exp) == null)
		{
			System.out.println("Expediente no encontrado.");
		}
		else
		{
			System.out.println("Alumno borrado.");
		}
	}
}
