package controllers;

import play.data.Form;
import play.data.DynamicForm;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	private static double a;
	private static String result = " . . . ";
	private static double b;
	private static double c;

	public static Result index() {
		return ok(index.render(result));
	}
 
	public static Result calc() {

		DynamicForm form = Form.form().bindFromRequest();

		a = Double.parseDouble(form.data().get("a"));
		b = Double.parseDouble(form.data().get("b"));
		c = Double.parseDouble(form.data().get("c"));

		calcResult();

		return redirect(routes.Application.index());
	}

	private static void calcResult() {

		double delta = ((b * b) - (4 * a * c));

		result = " x1 = " + (-b + Math.sqrt(delta)) / (2 * a) + " & "
				+ " x2 = " + (-b - Math.sqrt(delta)) / (2 * a);

	}
}
