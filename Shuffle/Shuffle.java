import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * �뷡 �迭�� 10���� �뷡�� ����ִ�
 * Function shuffle(int num)
 * ���ڸ� �־��� ��
 * ���ڰ� �뷡 ��ϰ� ���ų� ũ�� ��ü�� �����ϰ�
 * ������ �� ����ŭ �����ؼ� �����õ� ����Ʈ�� ����
 * 
 * ���� �˰��� : Fisher-Yates shuffle
 */
public class Shuffle {
	public int[] Songs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public int[] shuffle(int num){
		int length = Songs.length;
		int[] shuffledArr;
		
		if(num >= length)
			num = length;
		
		shuffledArr = new int[num];
		
		Random rnd = ThreadLocalRandom.current();
		for(int i = length-1; i > 0; i--){
			int index = rnd.nextInt(i+1);
			int temp = Songs[index];
			Songs[index] = Songs[i];
			Songs[i] = temp;
		}
		
		System.arraycopy(Songs, 0, shuffledArr, 0, num);
		
		return shuffledArr;
	}
}