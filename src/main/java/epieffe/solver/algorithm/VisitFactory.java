package epieffe.solver.algorithm;

import java.util.List;

import epieffe.solver.heuristic.Heuristic;
import epieffe.solver.problem.Move;
import epieffe.solver.problem.Problem;

/**
 * Created by user on 05/03/17.
 */
public class VisitFactory {

    public static Visit aStar() {
        return Visits::aStar;
    }

    public static Visit bestFirst() {
        return Visits::bestFirstGreedy;
    }

    public static Visit bfs() {
        return new Visit() {
            @Override
            public <T> List<Move<T>> start(Problem<T> problem, T config, Heuristic<T> h) {
                return Visits.bfs(problem, config);
            }
        };
    }

    public static Visit dijkstra() {
        return new Visit() {
            @Override
            public <T> List<Move<T>> start(Problem<T> problem, T config, Heuristic<T> h) {
                return Visits.dijkstra(problem, config);
            }
        };
    }

    public static Visit aStar(int approx) {
        return new Visit() {
            @Override
            public <T> List<Move<T>> start(Problem<T> problem, T config, Heuristic<T> h) {
                return Visits.aStar(problem, config, h, approx);
            }
        };
    }
}
