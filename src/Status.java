public enum Status {
    NONE, //1 ничего нет
    BORN, //2 делится
    LIVE, //1 жива клетка
    DIED; //2 умирает

    public Status step1 (int around)
    {
        switch (this)
        {
            case NONE: return (around==3) ? BORN: NONE;
            case LIVE: return (around<2 || around>3) ? DIED: LIVE;
            default: return this;
        }
    }

    public Status step2(){
        switch (this){
            case BORN: return LIVE;
            case DIED: return NONE;
            default: return this;
        }
    }

    public boolean isCell(){
        return this == LIVE || this==DIED;
    }
}
