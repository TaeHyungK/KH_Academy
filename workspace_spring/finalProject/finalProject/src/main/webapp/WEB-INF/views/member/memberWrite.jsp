<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>
<div class="container">
	 <div class="row">
                <div class="col-md-12">
                    <div class="contact-section">
                        <h3 class="section-title">Contact with Us</h3>
                        <!-- Start Contact Form -->
                        <div id="contact-form" class="contatct-form">
                            <div class="loader"></div>
                            <form action="mail.php" class="contactForm" name="cform" method="post">
                                <div class="row">
                                    <div class="col-md-4">
                                        <label for="name">Name<span class="required">*</span></label>
                                        <input id="name" name="name" type="text" value="" size="30">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="e-mail">Email<span class="required">*</span></label>
                                        <input id="e-mail" name="email" type="text" value="" size="30">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="url">Website</label>
                                        <input id="url" name="url" type="text" value="" size="30">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <label for="message">Add Your Comment</label>
                                        <textarea id="message" name="message" cols="45" rows="10"></textarea>
                                        <input type="submit" name="submit" class="btn btn-primary" id="submit_btn" value="Send Message">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- End Contact Form -->
                    </div>
                </div>
            </div>

</div>
























