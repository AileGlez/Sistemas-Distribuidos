/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micliententedeservicioweb;

/**
 *
 * @author tabat
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(add(3,4));
    }

    private static int add(int i, int j) {
        MyWebService.MyWebService_Service service = new MyWebService.MyWebService_Service();
        MyWebService.MyWebService port = service.getMyWebServicePort();
        return port.add(i, j);
    }
    
}
