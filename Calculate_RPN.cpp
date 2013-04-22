#include <iostream>
#include <string>
#include <stack>
#include <cstdlib>
using namespace std;

class Token
{
private:
	double tval;
public:
	Token(double val)
	{
		tval = val;
	}
	double getValue()
	{
		return tval;
	}
};


int getPriority( char op )
{
	if( op == '+' || op == '-' )
		return 2;
	if( op == '*' || op == '/' )
		return 3;
	if( op == '(' || op == ')' )
		return 0;
	if( op == '#' )
		return 0;
}

string getNextItem( string& expr, int& pos )
{
	string ans = "";
	while( pos < expr.size() && expr[pos] == ' ' )
		pos++;
	if( pos >= expr.size() ) 
		return ans;
	while( pos < expr.size() && expr[pos] != ' ' )
	{
		ans += expr[pos];
		pos++;
	}
	return ans;
}

double calculate( Token& t1, Token& t2, char op )
{
	double num1 = t1.getValue();
	double num2 = t2.getValue();
	if( op == '+' )
		return num1 + num2;
	else if( op == '-' )
		return num1 - num2;
	else if( op == '*' )
		return num1 * num2;
	else if( op == '/' )
		return num1 / num2;
	else 
		return 0;
}
/*********************************************

					Problem B
			need functions: getNextItem(), calculate()
					
**********************************************/
double CalculateRPN( string& expr )
{
	stack<Token> stknum;
	int i = 0;
	while( i < expr.size() )
	{
		string item = getNextItem( expr, i );
		if( item.size() == 1 && !isdigit( item[0] ) )
		{
			char op = item[0];
			Token t1 = stknum.top();
			stknum.pop();
//			cout << t1.getValue() << " ";
			Token t2 = stknum.top();
			stknum.pop();
//			cout << t2.getValue() << " ";
			double ans = calculate( t2, t1, op );
			Token obj = Token(ans);
			stknum.push(obj);
//			cout << obj.getValue() << " ";
		}
		else
		{
			double num = (double)atof( item.c_str() );
			Token obj = Token(num);
			stknum.push(obj);
		}
	}
	double ans = stknum.top().getValue();
	return ans;
}


/*********************************************

					Problem C
			need functions:   getNextItem(), getPriority()	
					
**********************************************/
void ConvertRPN( string& expr, string& rpn )
{
	rpn = "";
	expr += " #";
	stack<char> stkop;
	stkop.push('#');
	int pos = 0;
	while( pos < expr.size() )
	{
		string item = getNextItem( expr, pos );
//		cout << item << endl;
//		cout << stkop.size() << endl;
		if( item.size() == 1 && !isdigit( item[0] ) )
		{
			char op = stkop.top();
			
			if( item[0] == '(' )
				stkop.push( item[0] );
			else if( item[0] == ')' )
			{
				while( stkop.top() != '(' )
				{
					char op = stkop.top();
					stkop.pop();
					rpn += ' ';
					rpn += op;
					
				}
				stkop.pop();
			}
			else if( item[0] == '#' )
			{
				while( !stkop.empty() )
				{
					char op = stkop.top();
					stkop.pop();
					if( op != '#' )
					{
						rpn += ' ';
						rpn += op;
					}
				}
			}
			else if( getPriority( item[0] ) > getPriority( op ) )
				stkop.push( item[0] );
			else
			{
				while( getPriority( item[0] ) <= getPriority( stkop.top() ) )
				{
					char op = stkop.top();
					stkop.pop();
					if( op != '(' && op != ')' )
					{
						rpn += ' ';
						rpn += op;
					}
				}
				stkop.push( item[0] );
			}
		}
		else
		{
			rpn += ' ';
			rpn += item;
		}
//		cout << rpn << endl;
//		test(stkop);
	}
}

/*******************************************************

					Problem D
		need the functions of Problem B and Probem C 
					
*******************************************************/
double CalculateExpression( string expr )
{
	string RPN;
	ConvertRPN( expr, RPN );
	double ans = CalculateRPN( RPN );
	return ans;
}


int main()
{
	string expr;
	getline( cin, expr );
	string RPN;
	ConvertRPN( expr, RPN );
	double ans = CalculateRPN( RPN );
	cout << ans << endl;
	return 0;	
}

