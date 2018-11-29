<%@page import="com.common.ImageFileReadUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.BroadcastImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title><s:text name="index.profile.title"/></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="/profile/css/normalize.css">
        <link rel="stylesheet" href="/profile/css/font-awesome.css">
        <link rel="stylesheet" href="/profile/css/bootstrap.min.css">
        <link rel="stylesheet" href="/profile/css/templatemo-style.css">
        <script src="/profile/js/vendor/modernizr-2.6.2.min.js"></script>
    </head>

    <script type="text/javascript">
	</script>

    <body>
        <div class="responsive-header visible-xs visible-sm">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="top-section">
                            <div class="profile-image">
                                <img src="/profile/img/honda.jpg" alt="Volton">
                            </div>
                            <div class="profile-content">
                                <h3 class="profile-title"><s:text name="index.profile.title"/></h3>
                                <p class="profile-description"><s:text name="index.profile.description"/></p>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                <div class="main-navigation responsive-menu">
                    <ul class="navigation">
                        <li><a href="#top"><i class="fa fa-home"></i><s:text name="index.sidebar.welcome"/></a></li>
                        <li><a href="#about"><i class="fa fa-user"></i><s:text name="index.sidebar.aboutme"/></a></li>
                        <li><a href="#projects"><i class="fa fa-newspaper-o"></i><s:text name="index.sidebar.mygallery"/></a></li>
                        <li><a href="#contact"><i class="fa fa-envelope"></i><s:text name="index.sidebar.contactme"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
		
        <!-- SIDEBAR -->
        <div class="sidebar-menu hidden-xs hidden-sm">
            <div class="top-section">
                <div class="profile-image">
                    <img src="/profile/img/honda.jpg" alt="Volton">
                </div>
                <h3 class="profile-title"><s:text name="index.profile.title"/></h3>
                <p class="profile-description">&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="index.profile.description"/></p>
                <p class="profile-description">&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="index.profile.company"/></p>
            </div> <!-- top-section -->
            <div class="main-navigation">
                <ul class="navigation">
                    <li><a href="#top"><i class="fa fa-globe"></i><s:text name="index.sidebar.welcome"/></a></li>
                    <li><a href="#about"><i class="fa fa-pencil"></i><s:text name="index.sidebar.aboutme"/></a></li>
                    <li><a href="#projects"><i class="fa fa-paperclip"></i><s:text name="index.sidebar.mygallery"/></a></li>
                    <li><a href="#contact"><i class="fa fa-link"></i><s:text name="index.sidebar.contactme"/></a></li>
                </ul>
            </div> <!-- .main-navigation -->
            <div class="social-icons">
                <ul>
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="#"><i class="fa fa-rss"></i></a></li>
                </ul>
            </div> <!-- .social-icons -->
        </div> <!-- .sidebar-menu -->

		<div class="copyrights">from <a href="www.dengjl.com" ><s:text name="index.url"/></a></div>

        <div class="banner-bg" id="top">
            <div class="banner-overlay"></div>
            <div class="welcome-text">
                <h2><s:text name="index.welcome.name"/></h2>
                <h5><s:text name="index.welcome.signiture"/></h5>
                <br/>
                <h5><s:text name="index.welcome.description"/></h5>
                <br/>
                <h5><s:property value="returnMessage"/></h5>
            </div>
        </div>

        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="fluid-container">
                <div class="content-wrapper">
                    <!-- ABOUT -->
                    <div class="page-section" id="about">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="widget-title"><s:text name="index.content.aboutme"/></h4>
                            <div class="about-image">
                                <img src="/profile/img/certs.jpg" alt="about me">
                            </div>
                            <p>Working in NOKIA</p>
                            <p>Scrum Master</p>
                            <p>DevOps Master</p>
                            <p>Project Management Professional</p>
                            <p>Team Leader</p>
                            <hr>
                        </div>
                    </div> <!-- #about -->
                    </div> 
                    
                    <!-- PROJECTS -->
                    <div class="page-section" id="projects">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="widget-title"><s:text name="index.content.mygallery"/></h4>
                            <p>My life, My work</p>
                        </div>
                    </div>
                    <div class="row projects-holder">
<%
String realPath = request.getRealPath("");
List<BroadcastImage> fileList = ImageFileReadUtil.getBroadCastImageFiles(realPath);
request.setAttribute("fileList", fileList);
%>
<s:iterator value='#request.fileList' var="image">
						<div class="col-md-4 col-sm-6">
						    <div class="project-item">
						        <img src="<s:property value="#image.filePath"/>" alt="">
						        <div class="project-hover">
						            <div class="inside">
						                <h5><a href="#"></a></h5>
						                <p><s:property value="#image.alt"/></p>
						            </div>
						        </div>
						    </div>
						</div>
</s:iterator>
                    </div> <!-- .projects-holder -->
                    </div>
                    <hr>

                    <!-- CONTACT -->
                    <div class="page-section" id="contact">
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="widget-title"><s:text name="index.content.message"/></h4>
                            <p><s:text name="index.content.message.warning"/></p>
                        </div>
                    </div>
                    <div class="row">
                        <form action="/main/sendmessage" method="post" class="contact-form">
                            <fieldset class="col-md-4 col-sm-6">
                                <input type="text" id="your-name" name="name" placeholder="Your Name...">
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-6">
                                <input type="email" id="email" name="email" placeholder="Your Email...">
                            </fieldset>
                            <fieldset class="col-md-4 col-sm-12">
                                <input type="text" id="your-subject" name="subject" placeholder="Subject...">
                            </fieldset>
                            <fieldset class="col-md-12 col-sm-12">
                                <textarea name="message" id="message" cols="30" rows="6" placeholder="Leave your message..."></textarea>
                            </fieldset>
                            <fieldset class="col-md-12 col-sm-12">
                                <input type="submit" class="button big default" value="Send Message">
                            </fieldset>
                        </form>
                    </div> <!-- .contact-form -->
                    </div>
                    <hr>

                    <div class="row" id="footer">
                        <div class="col-md-12 text-center">
                            <p class="copyright-text">Copyright &copy; 2018 Allan DENG - <a href="http://www.dengjl.com"><s:text name="index.url"/></a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/profile/js/vendor/jquery-1.10.2.min.js"></script>
        <script src="/profile/js/min/plugins.min.js"></script>
        <script src="/profile/js/min/main.min.js"></script>
    </body>
</html>