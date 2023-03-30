package leetcode.StackAndQueue;

import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a nowcoder.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Test2_反转单词序列 {
    public String ReverseSentence(String str) {
        Stack<String> words = new Stack<>();
        String[] temp = str.split(" ");
        // 将单词放入栈中
        for (int i = 0; i < temp.length; i++) {
            words.push(temp[i]);
            words.push(" ");
        }
        StringBuilder res = new StringBuilder();
        // 去掉最后一个空格
        if(!words.isEmpty()) {
            words.pop();
        }
        while (!words.isEmpty()) {
            res.append(words.pop());
        }
        return res.toString();
    }
}
