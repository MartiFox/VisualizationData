
  //========================================================================
  // Вспомогательные класс для формирования заголовка HTML-cтраницы
  public class stdhead
  {
    public static String mkHead(String title)
    {
      String hd=
        "<!DOCTYPE HTML PUBLIC \".//W3C//DTD HTML 4.0 Transitional//EN\">\n"+
        "<HTML>\n" +
        "<HEAD>\n" +
        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1251\">\n" +  
        "<meta name=\"Keywords\" content=\"диаграммы, diagrams\">\n" +
        " <script src=\"https://d3js.org/d3.v5.min.js\"></script>" + 
        "<title>"+
        title +   // занесение содержимого в титул
        "</title>\n" +
        "<! (C) Owner: AK >\n" +
        "<! (C) НТУ \"ХПИ\". Каф.Информатики и интеллектуальной собственности, 2018. >\n" +
        "<link rel='shortcut icon' href='images/icon.png' type='image/x-icon'>"+	
    	"<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>"+
    	"<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100,500' rel='stylesheet' type='text/css'>"+
    	"<link rel='stylesheet' href='css/animate.css'>"+
    	"<link rel='stylesheet' href='css/icomoon.css'>"+
    	"<link rel='stylesheet' href='css/simple-line-icons.css'>"+
    	"<link rel='stylesheet' href='css/style.css'>"+

        "</head>\n" +
    	"<header id='fh5co-header' role='banner'>"+
		"<nav class='navbar navbar-default' role='navigation'>"+
			"<div class='container'>"+
				"<div class='row'>"+
					"<div class='col-md-10 col-md-offset-1'>"+
						"<div class='navbar-header'> "+
						"<a href='#' class='js-fh5co-nav-toggle fh5co-nav-toggle visible-xs-block' data-toggle='collapse' data-target='#fh5co-navbar' aria-expanded='false' aria-controls='navbar'><i></i></a>"+
						"<a class='navbar-brand' href='index.html'><img src=images/social.png width='200' height='100' border=0> </a>"+
						"</div>"+
						"<div id='fh5co-navbar' class='navbar-collapse collapse'>"+
							"<ul class='nav navbar-nav navbar-right'>"+
								"<li class='active'><a href='index.html'><img src=images/thankyou.jpg width='100' height='100' border=0><span>Авторизация <span class='border'></span></span></a></li>"+
								"<li><a href=contacts><img src=images/contact.jpeg width='100' height='100' border=0><span>Контакты<span class='border'></span></span></a></li>"+
								"<li><a href='support.html'><img src=images/help.png width='100' height='100' border=0><span>Помощь<span class='border'></span></span></a></li>"+
							"</ul>"+
						"</div>"+
					"</div>"+
				"</div>"+
			"</div>"+
		"</nav>"+
	"</header>";
      return hd;
    }
  }