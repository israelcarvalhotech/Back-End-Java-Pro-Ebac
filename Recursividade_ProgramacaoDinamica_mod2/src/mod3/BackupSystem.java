package mod3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Uma empresa quer implementar  um novo sistema de backup no qual arquivos são guardados em fitas de dados.
 * 
 * O novo sistema deve seguir as seguintes regras:
 * 1- nunca colocar mais de dois arquivos na mesma fita;
 * 2- os arquivos não podem ser divididos em múltiplas fita;
 * 
 * É garantido q todas as fitas tenham o mesmo tamanho e que elas sempre seram capazes de guardar o mesmo arquivo.
 * Toda vez que este processo for executado, nós ja saberemos o tamanho de cada arquivo e a capacidade das fitas.
 * Com isso em mente, desenhe uma solução que saja capaz de contar quantas fitas serão requeridas para guardar o bakup de forma mais eficiente.
 * O parâmetro de sua função será uma estrutura que conterá o tamanho dos arquivos e a capacidade das fitas.
 * Você deve retornar a quantidade mínima de fitas requerida para guardar os arquivos.
 * 
 * Ex:
 * Input: Tape Size = 100; Files: 70, 10, 20
 * Output: 2
 * 
*/

public class BackupSystem {

	public interface Batch {
		int[] getFileSizes();

		int getTapeSize();
	}

	private static class NewBatch implements Batch {

		@Override
		public int[] getFileSizes() {
			return new int[] { 70, 10, 20, 40, 50, 60, 50, 100, 100 };
		}

		@Override
		public int getTapeSize() {
			return 100;
		}

	}

	private class Tape {

		private int stored;
		private int numberOfFiles;

		public Tape(int stored) {
			this.stored = stored;
			this.numberOfFiles = 1;
		}

		public int getStored() {
			return stored;
		}

		public void addStorage(int storage) {
			this.stored += storage;
		}

		public int getNumberOfFiles() {
			return numberOfFiles;
		}

		public void addfiles() {
			this.numberOfFiles++;
		}

	}

	public int getMiniumTapeCount(final Batch batch) {
		// primeiro ordenar o array de tamanhos;
		int[] sizes = batch.getFileSizes();
		Arrays.sort(sizes);

		int tapes = 0;
		List<Tape> list = new ArrayList<>();

		for (int i = sizes.length - 1; i > -1; i--) {
			boolean stored = false;

			for (Tape tape : list) {
				if (((tape.getStored() + sizes[i]) <= batch.getTapeSize()) && (tape.getNumberOfFiles() < 2)) {
					tape.addStorage(sizes[1]);
					tape.addfiles();
					stored = true;
					break;
				}
			}

			if (!stored) {
				tapes++;
				list.add(new Tape(sizes[1]));
			}
		}

		return tapes;
	}

	public static void main(String[] args) {
		BackupSystem backupSystem = new BackupSystem();
		Batch batch = new NewBatch();

		System.out.println(backupSystem.getMiniumTapeCount(batch));
	}

}
