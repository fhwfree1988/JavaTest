package Sample.MultiThread.ThreadPool;

//import org.assertj.core.util.Sets;

import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ThreadForkJoinPool {
    //https://www.baeldung.com/thread-pool-java-and-guava
    /*public static void main(String[] args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(3), new TreeNode(2,
                new TreeNode(2), new TreeNode(8)));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int sum = forkJoinPool.invoke(new CountingTask(tree));
    }
    static class TreeNode {

        int value;

        Set<TreeNode> children_m;

        TreeNode(int value, TreeNode... children) {
            this.value = value;
            this.children_m = Sets.newHashSet(children);
        }
    }
    public static class CountingTask extends RecursiveTask<Integer> {

        private final TreeNode node;

        public CountingTask(TreeNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            return node.value + node.children.stream()
                    .map(childNode -> new CountingTask(childNode).fork())
                    .collect(Collectors.summingInt(ForkJoinTask::join));
        }
    }*/
}
