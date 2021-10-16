import model.Pet;
import service.RetrofitClient;
import service.RetrofitConfig;

public class Application {

    RetrofitConfig retrofitConfig = new RetrofitConfig();
    RetrofitClient retrofitClient = retrofitConfig.createClient("https://petstore.swagger.io/v2/",RetrofitClient.class);

    public static void main(String[] args) {

      Application application = new Application();

        Pet requestPet = application.getRequestPet(application.retrofitClient);
        System.out.println(requestPet);


    }


    private Pet getRequestPet(RetrofitClient client){
        System.out.println("Get pet -> GET REQUEST");
        return retrofitConfig.execute(client.findById(1));
    }
}
