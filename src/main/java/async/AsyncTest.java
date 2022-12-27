package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

    private static List<Enterprise> enterprises = List.of(
            new Enterprise("ent_1", "Google", "ceo_2"),
            new Enterprise("ent_2", "Facebook", "ceo_1")
    );

    private static List<Ceo> ceos = List.of(
            new Ceo("ceo_1", "Mark"),
            new Ceo("ceo_2", "Sundar"),
            new Ceo("ceo_3", "Bill")
    );

    public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> ceos
                .filter(ceo -> ceo.id.equals(ceo_id)).peekOption());
    }

    public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> enterprises
                .filter(enterprise -> enterprise.ceo_id.equals(ceo_id)).peekOption());
    }

    public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
        try{
            Option<Enterprise> entreprise = getEnterpriseByCeoId(ceo_id).get();
            Option<Ceo> ceo = getCeoById(ceo_id).get();
            return CompletableFuture.supplyAsync(() -> Tuple.of(ceo, entreprise));
        }catch (InterruptedException | ExecutionException e) {
            return CompletableFuture.supplyAsync(() -> Tuple.of(Option.none(), Option.none()));
        }
    }
}