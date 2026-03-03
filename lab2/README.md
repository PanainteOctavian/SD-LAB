MonitorControlServlet porneste instanta de monitorizare "monitor" prin value = start din tag-ul html de input.
In monitor, scheduler-ul apeleaza functia "checkDatabase" din 10 in 10 secunde.
In checkDatabase, se face un SQL query care imi genereaza tabelu cu erori pe care l integrez in pagina html cu alarmele mele,  "alarm.html".
AlarmViewServlet este un servlet facut pt ca nu pot afisa pagini html(precum alarm.html) de pe pc-ul meu direct in MonitorViewServlet.


