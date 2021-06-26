package com.datastructure.distributed;

import com.netopyr.wurmloch.crdt.PNCounter;
import com.netopyr.wurmloch.store.LocalCrdtStore;
import com.netopyr.wurmloch.crdt.PNCounter;
import com.netopyr.wurmloch.store.LocalCrdtStore;

import org.junit.Test;

/**
 * CRDTTest class
 *
 * @author 格林
 * @date 2021-06-26
 */
public class CRDTTest {
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
//        assertThat(replica1.get()).isEqualTo(-1L);
//        assertThat(replica2.get()).isEqualTo(-1L);

        crdtStore1.disconnect(crdtStore2);

        replica1.decrement(3L);
        replica2.increment(5L);

        System.out.println(replica1.get() == -4L);
        System.out.println(replica2.get() == 4L);
//        assertThat(replica1.get()).isEqualTo(-4L);
//        assertThat(replica2.get()).isEqualTo(4L);

        crdtStore1.connect(crdtStore2);

        System.out.println(replica1.get() == 1L);
        System.out.println(replica2.get() == 1L);
//        assertThat(replica1.get()).isEqualTo(1L);
//        assertThat(replica2.get()).isEqualTo(1L);
    }
}
