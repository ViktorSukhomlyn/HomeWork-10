class ResultWord implements Comparable <ResultWord> {

    private String word;
    private int count;

    public ResultWord(String word, int count) {
        this.word = word;
        this.count = count;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return word + " " + count;
    }

    @Override
    public int compareTo(ResultWord other) {
        return Integer.compare(this.count, other.count);
    }
}