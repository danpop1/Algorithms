// QuickSort.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
using namespace std;

int partitie(int a[100], int start, int end) {

	int index = start,aux,i;
	int pivot = a[end];
	for (i = start; i < end; i++) {
		if (a[i] <= pivot) {
			aux = a[i];
			a[i] = a[index];
			a[index] = aux;
			index++;
		}
	}
	aux = a[end];
	a[end] = a[index];
	a[index] = aux;

	return index;
}

void quicksort(int a[100], int start, int end) {
	if (start < end) {
		int index = partitie(a, start, end);
		quicksort(a, start, index - 1);
		quicksort(a, index + 1, end);
	}
}

int main()
{
	int n;
	cin >> n;
	int a[100];

	for (int i = 0; i <n; i++) {
		cin >> a[i];
	}

	cout << "Inainte de sortare: " << endl;
	for (int i = 0; i < n; i++) {
		cout << a[i] << " ";
	}
	cout << endl;

	cout << "Dupa sortare: " << endl;

	quicksort(a, 0, n - 1);

	for (int i = 0; i < n; i++) {
		cout << a[i] << " ";
	}

	return 0;
}


