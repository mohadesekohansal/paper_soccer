import java.util.ArrayList;
import java.math.*;

public class Minimax {

	int state;
	Action action;
	Points[] points_copy;

	ArrayList<Points> po = new ArrayList<Points>();
	int i = 0;

	public Minimax(int state) {
		// TODO Auto-generated constructor stub
		this.state = state;
		// this.points = points;

	}

	public Action minimax_decision(int state, Points[] points) {
		Pair pair;
		// points_copy = points.clone();
		for (Points p : points) {
			po.add(p);
		}
		System.out.println("state : " + state);
		pair = Max_Value(state, points);
		action = new Action(state, pair.successor, pair.value);
		System.out.println(
				action.state + " " + action.successor + " " + action.value + "       " + points[action.state].value);

		return action;

	}

	private Pair Max_Value(int current_state, Points[] points) {
		// TODO Auto-generated method stub
		Pair pair = null;
		boolean max = true;
		ArrayList<Integer> suc = new ArrayList<Integer>();
		int utility = terminal_test(current_state, max, points);
		if (utility != 0) {

			return pair = new Pair(utility, 0);
		}
		for (Points p : points) {
			p.value = -100000;
		}
		suc = successor(current_state, points);

//		System.out.println("Max suc: " + suc + current_state);

		for (Integer s : suc) {

//			System.out.println("Max " + s);

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
			points[current_state].value = Math.max(points[current_state].value, Min_Value(s, points).value);
			pair = new Pair(points[current_state].value, s);
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

	private Pair Min_Value(int current_state, Points[] points) {
		// TODO Auto-generated method stub
		Pair pair = null;
		boolean min = false;
		ArrayList<Integer> suc = new ArrayList<Integer>();
		int utility = terminal_test(current_state, min, points);
		if (utility != 0) {

			return pair = new Pair(utility, 0);
		}

		for (Points p : points) {
			p.value = +100000;
		}

		suc = successor(current_state, points);

//		System.out.println("Min suc: " + suc + current_state);

		for (Integer su : suc) {

//			System.out.println("Min " + su);

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
			points[current_state].value = Math.min(points[current_state].value, Max_Value(su, points).value);
			pair = new Pair(points[current_state].value, su);

		}

		return pair;
	}

	private ArrayList<Integer> successor(int state, Points[] points) {
		// TODO Auto-generated method stub
		ArrayList<Integer> suc = new ArrayList<Integer>();
		if ((state > 2 && state < 6) || (state > 92 && state < 96)) {
			if (state == 3) {
				suc.add(103);
			} else if (state == 4) {
				suc.add(102);
				suc.add(103);
				suc.add(104);
			} else if (state == 5) {
				suc.add(103);
			} else if (state == 93) {
				suc.add(100);
			} else if (state == 94) {
				suc.add(99);
				suc.add(100);
				suc.add(101);
			} else if (state == 95) {
				suc.add(100);
			}
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
		if (points[state].a) {
			if (state - 1 > -1 && state - 1 < 99)
				suc.add(state - 1);
		}
		if (points[state].z) {
			if (state + 8 > -1 && state + 8 < 99)
				suc.add(state + 8);
		}

		return suc;
	}

	public int terminal_test(int state, boolean flag, Points[] points) {
		// TODO Auto-generated method stub
		int result = 0;

		if (state == 99 || state == 100 || state == 101) {
			result = -10;
		} else if (state == 102 || state == 103 || state == 104) {
			result = +10;
		} else if (points[state].adj == 8) {// it may have problem
			if (flag) {
				result = -1;
			} else {
				result = 1;
			}
		} else if (successor(state, points).isEmpty()) {
			if (flag) {
				result = -1;
			} else {
				result = 1;
			}
		}
		return result;
	}

}
