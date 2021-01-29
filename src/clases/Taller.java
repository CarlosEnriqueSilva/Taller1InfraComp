package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller extends Thread {
	
	// Verdadero si imprime pares, falso si imprime impares
	private boolean imprimirPares;
	private int limSuperior;
	
	public Taller(boolean impPar, int limS)
	{
		imprimirPares = impPar;
		limSuperior = limS;
	}
	
	public void run()
	{
		if(imprimirPares == true)
		{
			for(int i = 1; i <= limSuperior; i++)
			{
				if(i%2==0)
				{
					System.out.println(i);
					try
					{
						Taller.sleep(800);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
			}
		}
		else
		{
			for(int i = 1; i <= limSuperior; i++)
			{
				if(i%2!=0)
				{
					System.out.println(i);
					try
					{
						Taller.sleep(800);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args)throws IOException {
		
		// Leer la entrada estandar 
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int limSup = Integer.parseInt(reader.readLine());
		
		Taller thread1 = new Taller(true, limSup);
		thread1.start();

		Taller thread2 = new Taller(false, limSup);
		thread2.start();
	
	}

}
