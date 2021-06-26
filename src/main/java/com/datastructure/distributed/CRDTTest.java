package com.datastructure.distributed;

import com.netopyr.wurmloch.crdt.LWWRegister;
import com.netopyr.wurmloch.crdt.MVRegister;
import com.netopyr.wurmloch.crdt.PNCounter;
import com.netopyr.wurmloch.store.LocalCrdtStore;
import javaslang.collection.Array;
import org.junit.Test;

import java.util.Arrays;

/**
 * CRDTTest class
 *
 * @author 格林
 * @date 2021-06-26
 */
public class CRDTTest {


    @Test
    public void testRegisterMV(){
        LocalCrdtStore crdtStore1 = new LocalCrdtStore("N_1");
        LocalCrdtStore crdtStore2 = new LocalCrdtStore("N_2");
        crdtStore1.connect(crdtStore2);

        MVRegister<String> replica1 = crdtStore1.createMVRegister("ID_1");

        MVRegister<String> replica2 = crdtStore2.<String>findMVRegister("ID_1").get();

        replica1.set("xxp");
        replica2.set("xxp2");

        Array<String> strings = replica1.get();
        System.out.println(strings.get());
        System.out.println(replica2.get().equals("banana"));

    }

    @Test
    public void testRegister(){
        LocalCrdtStore crdtStore1 = new LocalCrdtStore("N_1");
        LocalCrdtStore crdtStore2 = new LocalCrdtStore("N_2");
        crdtStore1.connect(crdtStore2);

        LWWRegister<String> replica1 = crdtStore1.createLWWRegister("ID_1");
        LWWRegister<String> replica2 = crdtStore2.<String>findLWWRegister("ID_1").get();

        replica1.set("apple");
        replica2.set("banana");

        System.out.println(replica1.get().equals("banana"));
        System.out.println(replica2.get().equals("banana"));

    }
    @Test
    public void testPNCount() {
        LocalCrdtStore crdtStore1 = new LocalCrdtStore();
        LocalCrdtStore crdtStore2 = new LocalCrdtStore();
        crdtStore1.connect(crdtStore2);

        PNCounter replica1 = crdtStore1.createPNCounter("ID_1");
        PNCounter replica2 = crdtStore2.findPNCounter("ID_1").get();

        replica1.increment();
        replica2.decrement(2L);

        System.out.println(replica1.get() == -1L);
        System.out.println(replica2.get() == -1L);


        crdtStore1.disconnect(crdtStore2);

        replica1.decrement(3L);
        replica2.increment(5L);

        System.out.println(replica1.get() == -4L);
        System.out.println(replica2.get() == 4L);


        crdtStore1.connect(crdtStore2);

        System.out.println(replica1.get() == 1L);
        System.out.println(replica2.get() == 1L);

    }
}
