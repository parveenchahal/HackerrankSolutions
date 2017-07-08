#include<iostream>
using namespace std;
#define MAX 500

void printReverseString(char *str) {
    if(*str == '\0') {
        return;
    }
    printReverseString(str + 1);
    cout<<*str;
}
void multiply(int x, char result[])
{
    int carry = 0;
    int i = 0;
    while(result[i] != '\0')
    {
        int p = (result[i] - '0') * x + carry;
        result[i] = (p % 10) + '0';
        carry  = p/10;
        i++;
    }
    while (carry > 0)
    {
        result[i++] = (carry % 10) + '0';
        carry = carry/10;
    }
}

void factorial(int n)
{
    char result[MAX];
    for(int i = 0; i < MAX; i++) {
        result[i] = '\0';
    }
    result[0] = 1 + '0';
    for (int x = 2; x <= n; x++) {
        multiply(x, result);
    }
    printReverseString(result);
}

int main()
{
    int N;
    cin>>N;
    factorial(N);
    return 0;
}

