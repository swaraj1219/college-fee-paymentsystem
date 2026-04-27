package basic;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FeeServlet")
@MultipartConfig
public class FeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        double total = Double.parseDouble(request.getParameter("total"));
        double paid = Double.parseDouble(request.getParameter("paid"));

        // Calculate due amount
        double due = total - paid;

        String bank = request.getParameter("bank");
        String date = request.getParameter("date");
        String lastdate = request.getParameter("lastdate");
        
        Part filePart = request.getPart("photo");
        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("/images");

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        filePart.write(uploadPath + File.separator + fileName);

   
        // Send data to JSP
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("total", total);
        request.setAttribute("paid", paid);
        request.setAttribute("due", due);
        request.setAttribute("bank", bank);
        request.setAttribute("date", date);
        request.setAttribute("lastdate", lastdate);
        request.setAttribute("photo", "images/" + fileName);

        // Forward to receipt page
        request.getRequestDispatcher("receipt.jsp").forward(request, response);
    }
}