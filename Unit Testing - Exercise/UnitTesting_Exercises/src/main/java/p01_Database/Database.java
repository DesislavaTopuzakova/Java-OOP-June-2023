package p01_Database;

import javax.naming.OperationNotSupportedException;

public class Database {

    //полета
    private Integer[] elements;
    private int elementsCount = 0;
    private int index;

    //конструктор -> създаваме нова база данни
    public Database(Integer... elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;
        this.setElements(elements);
        this.index = elementsCount - 1;
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = element;
        this.elementsCount++;
    }

    public void remove() throws OperationNotSupportedException {
		try {
			this.elements[index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

    public Integer[] getElements() {
        Integer[] buffer = new Integer[elementsCount];
        int bufferIndex = 0;

        for (Integer element : elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    private void setElements(Integer... elements) throws OperationNotSupportedException {
        if (elements.length > 16 ||
                elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Integer[16];
        int bufferIndex = 0;

        for (Integer element : elements) {
            this.elements[bufferIndex++] = element;
        }

        this.index = elements.length - 1;
    }

    public int getIndex() {
        return index;
    }

    public int getElementsCount() {
        return elementsCount;
    }
}
