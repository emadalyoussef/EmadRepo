package controllers;

import play.data.Form;
import play.data.DynamicForm;
import play.mvc.*;
//import scalaz.std.string;
import views.html.*;
import views.html.helper.form;

public class Application extends Controller {

	private static double a;
	private static String result = "";
	private static String equation = "";
	private static double b;
	private static double c;

	public static Result index() {
		return ok(index.render(equation + result));
	}

	public static Result calc() {

		DynamicForm form = Form.form().bindFromRequest();
		a = Double.parseDouble(form.data().get("a"));
		b = Double.parseDouble(form.data().get("b"));
		c = Double.parseDouble(form.data().get("c"));
		equation = "Equation: " + a + " X^2 + " + b + " X + " + c + " = 0 ///";
		calcResult();

		return redirect(routes.Application.index());
	}

	private static void calcResult() {

		double delta = ((b * b) - (4 * a * c));
		if (delta == 0)
			result = "Result: x1 = x2 = " + (-b / (2 * a));
		else if (delta < 0)
			result = "This has no solution";
		else
			result = "Result: " + " x1 = " + (-b + Math.sqrt(delta)) / (2 * a)
					+ " & " + " x2 = " + (-b - Math.sqrt(delta)) / (2 * a);

	}
}
