/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author hieund3
 */
public class AVL {

	public static Student root = null;

	public static void insert(Student student) {
		if (root == null) {
			root = student;
		} else {
//			putToSuitable(student);
//			rebalance(root);
		}
	}

	public static void delete(Student student) {
		
	}

	public static void main(String[] args) {
		Student a = new Student(1, 7.6);
		Student b = new Student(2, 8.8);
		Student c = new Student(3, 3.4);
		Student d = new Student(4, 9.8);
		Student e = new Student(5, 7.9);

	}

	static class Student {

		Student(int id, double score) {
			this.id = id;
			this.score = score;
		}

		Student left;
		Student right;
		int id;
		double score;
	}
}
