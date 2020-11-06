package design.single;

/**
 * @author wangrx23694
 * @date
 * @description
 */
public class LazyMod {
    // 非线程安全
    private static LazyMod lazyMod;

    public static LazyMod getInstance(){
        if(lazyMod == null){
            lazyMod = new LazyMod();
        }
        return lazyMod;
    }

    // 加锁
    public synchronized static LazyMod getLazyMod(){
        if(lazyMod == null) {
            lazyMod = new LazyMod();
        }
        return lazyMod;
    }


}
