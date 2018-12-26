import java.util.ArrayList;
import java.math.*;

public class Minimax {

	int state;
	Action action;
	Points[] point;
	Points[] points;
	int i = 0;

	public Minimax(int state, Points[] point) {
		// TODO Auto-generated constructor stub
		this.state = state;
		this.point = point;
		points = point;
	}

	public Action minimax_decision(int state) {
		Pair pair;
		System.out.println(state);
		pair = Max_Value(state);
		action = new Action(state, pair.successor, pair.value);
		System.out.println(action.state+" "+action.successor+" "+ action.value);
		return action;

	}

	private Pair Max_Value(int current_state) {
		// TODO Auto-generated method stub
		Pair pair = null;
		boolean max = true;
		ArrayList<Integer> suc = new ArrayList<Integer>();
		int utility = terminal_test(current_state, max);
		if (utility != 0) {

			return pair = new Pair(utility, 0);
		}
		int v = -100000;
		// if(i<100){
		System.out.println("Max succ: " + successor(current_state) + current_state);
		i++;
		// }
		suc = successor(current_state);

		// System.out.println("Max suc: " + suc + current_state);

		for (Integer s : suc) {
			// if(i<100){

			System.out.println("Max " + s);
			// }

			switch (getdirection(current_state, s)) {
			case 'a':
				points[current_state].a = false;
				points[s].d = false;
				break;
			case 'z':
				points[current_state].z = false;
				points[s].e = false;
				break;
			case 'x':
				points[current_state].x = false;
				points[s].w = false;
				break;
			case 'c':
				points[current_state].c = false;
				points[s].q = false;
				break;
			case 'd':
				points[current_state].d = false;
				points[s].a = false;
				break;
			case 'e':
				points[current_state].e = false;
				points[s].z = false;
				break;
			case 'w':
				points[current_state].w = false;
				points[s].x = false;
				break;
			case 'q':
				points[current_state].q = false;
				points[s].c = false;
				break;
			default:
				break;
			}
			v = Math.max(v, Min_Value(s).value);
			pair = new Pair(v, s);
		}

		return pair;
	}

	public char getdirection(int current_state, int suc) {
		// TODO Auto-generated method stub
		int dif = current_state - suc;
		char ch = 0;
		switch (dif) {
		case +1:
			ch = 'a';
			break;
		case -1:
			ch = 'd';
			break;
		case -8:
			ch = 'z';
			break;
		case -9:
			ch = 'x';
			break;
		case -10:
			ch = 'c';
			break;
		case 8:
			ch = 'e';
			break;
		case 9:
			ch = 'w';
			break;
		case 10:
			ch = 'q';
			break;

		default:
			break;
		}
		return ch;
	}

	private Pair Min_Value(int current_state) {
		// TODO Auto-generated method stub
		Pair pair = null;
		boolean min = false;
		ArrayList<Integer> suc = new ArrayList<Integer>();
		int utility = terminal_test(current_state, min);
		// System.out.println(terminal_test(current_state ,min));
		if (utility != 0) {

			return pair = new Pair(utility, 0);
		}
		int v = 100000;
		// if(i<100){

		System.out.println("Min succ: " + successor(current_state) + current_state);
		// i++;}
		suc = successor(current_state);

		// System.out.println("Min suc: " + suc + current_state);

		for (Integer su : suc) {

			// if(i<100){
			System.out.println("Min " + su);
			// }

			switch (getdirection(current_state, su)) {
			case 'a':
				points[current_state].a = false;
				points[su].d = false;
				break;
			case 'z':
				points[current_state].z = false;
				points[su].e = false;
				break;
			case 'x':
				points[current_state].x = false;
				points[su].w = false;
				break;
			case 'c':
				points[current_state].c = false;
				points[su].q = false;
				break;
			case 'd':
				points[current_state].d = false;
				points[su].a = false;
				break;
			case 'e':
				points[current_state].e = false;
				points[su].z = false;
				break;
			case 'w':
				points[current_state].w = false;
				points[su].x = false;
				break;
			case 'q':
				points[current_state].q = false;
				points[su].c = false;
				break;
			default:
				break;
			}
			v = Math.min(v, Max_Value(su).value);
			pair = new Pair(v, su);

		}

		return pair;
	}

	private ArrayList<Integer> successor(int state) {
		// TODO Auto-generated method stub
		ArrayList<Integer> suc = new ArrayList<Integer>();
		// if()
		if (points[state].a) {
			if (state - 1 > -1 && state - 1 < 99)
				suc.add(state - 1);
		}
		if (points[state].z) {
			if (state + 8 > -1 && state + 8 < 99)
				suc.add(state + 8);
		}
		if (points[state].x) {
			if (state + 9 > -1 && state + 9 < 99)
				suc.add(state + 9);
		}
		if (points[state].c) {
			if (state + 10 > -1 && state + 10 < 99)
				suc.add(state + 10);
		}
		if (points[state].d) {
			if (state + 1 > -1 && state + 1 < 99)
				suc.add(state + 1);
		}
		if (points[state].e) {
			if (state - 8 > -1 && state - 8 < 99)
				suc.add(state - 8);
		}
		if (points[state].w) {
			if (state - 9 > -1 && state - 9 < 99)
				suc.add(state - 9);
		}
		if (points[state].q) {
			if (state - 10 > -1 && state - 10 < 99)
				suc.add(state - 10);
		}
		return suc;
	}

	public int terminal_test(int state, boolean flag) {
		// TODO Auto-generated method stub
		int result = 0;
		if (state == 99 || state == 100 || state == 101) {
			result = 1;
		} else if (state == 102 || state == 103 || state == 104) {
			result = -1;
		} else if (point[state].adj == 8) {
			if (flag) {
				result = -1;
			} else {
				result = 1;
			}
		} else if (successor(state).isEmpty()) {
			if (flag) {
				result = -1;
			} else {
				result = 1;
			}
		}
		return result;
	}

}
