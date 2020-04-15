#include <iostream>
using namespace std;

void missingnumber(int a[100],int n,int first,int last) {
	//int i =0;
	for (int i=first; i < a[0]; i++) {
		cout << i << " ";
	}

	for (int i = 1; i < n; i++) {
		for (int j = 1 + a[i - 1]; j < a[i]; j++) {
			cout << j << " ";
		}
	}
   
	for (int j =1+a[n - 1]; j <= last; j++) {
		cout << j << " ";
	}
}

int main()
{
	int n, a[100],first, last;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	cin >> first >> last;
	missingnumber(a, n, first, last);

   // std::cout << "Hello World!\n";
	return 0;
}

