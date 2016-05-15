<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Recommend</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href='/visualize/css/font.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" href="/visualize/css/style.css">
</head>
<body>
	<%@include file="/visualize/common/navigation.jsp"%>

	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>Recommend</h1>
							<h4>We will recommend some interesting stuffs for you</h4>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>

	<div id="section2">
		<!-- Start Feature Area -->
		<section id="feature-area" class="about-section">
			<div class="container">
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<img src="/visualize/img/1st.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=8393">thoughtbot/paperclip</a>
							<p class="feature-content-description">Easy file attachment
								management for ActiveRecord</p>
							<p>Last updated : 2015-11-28</p>
							<p>Star : 144</p>
							<p>Fork : 222</p>
							<!-- <a href="#" class="feature-content-link green-btn">button green</a> -->
						</div>
					</div>
					<div class="col-sm-4">
						<div class="feature-content">
							<img src="/visualize/img/2nd.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=10865">norman/friendly_id</a>
							<p class="feature-content-description">FriendlyId is the
								“Swiss Army bulldozer” of slugging and permalink plugins for ActiveRecord. It allows you to create pretty URL’s and work with
								human-friendly strings as if they were numeric ids for ActiveRecord models.</p>
							<p>Last updated : 2015-11-28</p>
							<p>Star : 3780</p>
							<p>Fork : 421</p>
							<!-- <a href="#" class="feature-content-link blue-btn">See Details</a> -->
						</div>
					</div>
					<div class="col-sm-4">
						<div class="feature-content">
							<img src="/visualize/img/3rd.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=2376">ActsAsParanoid/acts_as_paranoid</a>
							<p class="feature-content-description">ActiveRecord plugin
								allowing you to hide and restore records without actually
								deleting them.</p>
							<p>Last updated : 2015-11-28</p>
							<p>Star : 144</p>
							<p>Fork : 222</p>
							<!-- <a href="#" class="feature-content-link red-btn">Button Red</a> -->
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Feature Area -->

		<!-- Start Blog Area -->
		<section id="blog-area">
			<div class="container">
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="blog-content">
							<img src="/visualize/img/4th.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=1734">aasm/aasm</a>
							<p>AASM - State machines for Ruby classes (plain Ruby,
								ActiveRecord, Mongoid, MongoMapper)</p>
							<!-- <br> -->
							<p>
								Last updated : 2015-1-18<br />Star : 2133<br />Fork : 328
							</p>

						</div>
					</div>
					<div class="col-sm-4">
						<div class="blog-content">
							<img src="/visualize/img/5th.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=2498">JackDanger/permanent_records</a>
							<p>Rails Plugin - soft-delete your ActiveRecord records. It's
								like an explicit version of ActsAsParanoid.</p>
							<p>
								Last updated : 2014-7-12<br />Star : 189<br />Fork : 48
							</p>
							<!-- <span><a href="#">read more</a></span><br> -->
							<p id="blofr"></p>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="blog-content">
							<img src="/visualize/img/5th.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/repository/content?id=2498">JackDanger/permanent_records</a>
							<p>Rails Plugin - soft-delete your ActiveRecord records. It's
								like an explicit version of ActsAsParanoid.</p>
							<p>
								Last updated : 2014-7-12<br />Star : 189<br />Fork : 48
							</p>
							<!-- <span><a href="#">read more</a></span><br> -->
							<p id="blofr"></p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Blog Area -->
	</div>
	
	<div id="section3">
		<!-- Start Title Area -->
		<section id="services-area" class="services-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center inner our-service">
						<div class="service">
							<h1>Guess You May Prefer</h1>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Services Area -->

		<!-- Start Testimornial Area -->
		<section id="testimornial-area">
			<div class="container">
				<div class="row text-center">
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-1.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/user/content?id=2">Chris
								Wanstrath</a>
							<p>
								Joined on 2007-10-20<br />email:chris@github.com<br />company:
								GitHub <br />Living in San Francisco
							</p>
							<br>
							<table border="1" width="100%">
								<col align="left" />
								<col align="left" />
								<col align="right" />
								<tr>
									<th>Efficiency</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
								<tr>
									<td>78</td>
									<td>69</td>
									<td>76</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-2.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/user/content?id=39191">Paul
								Irish</a>
							<p>
								Joined on 2008-12-09<br />email:jakewharton@gmail.com<br />company:
								Google Chrome, ♥z<br />Living in Palo Alto
							</p>
							<br>
							<table border="1" width="100%">
								<col align="left" />
								<col align="left" />
								<col align="right" />
								<tr>
									<th>Efficiency</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
								<tr>
									<td>78</td>
									<td>69</td>
									<td>76</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-3.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/user/content?id=66577">Jake
								Wharton</a>
							<p>
								Joined on 2009-03-24<br />email:jakewharton@gmail.com<br />company:
								Square, Inc.<br />Living in Pittsburgh, PA
							</p>
							<br>
							<table border="1" width="100%">
								<col align="left" />
								<col align="left" />
								<col align="right" />
								<tr>
									<th>Efficiency</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
								<tr>
									<td>78</td>
									<td>69</td>
									<td>76</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-4.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/GithubVisualization/user/content?id=1615">John
								Resig</a>
							<p>
								Joined on 2008-02-28<br />email:jeresig@gmail.com<br />company:
								Khan Academy<br />Living in Brooklyn, NY
							</p>
							<br>
							<table border="1" width="100%">
								<col align="left" />
								<col align="left" />
								<col align="right" />
								<tr>
									<th>Efficiency</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
								<tr>
									<td>78</td>
									<td>69</td>
									<td>76</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="row text-center">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-1.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/GithubVisualization/user/content?id=25254">TJ
									Holowaychuk</a>
								<p>
									Joined on 2008-09-18<br />email:tj@vision-media.ca<br />company:Unknow<br />Living
									in Victoria, BC, Canada
								</p>
								<br>
								<table border="1" width="100%">
									<col align="left" />
									<col align="left" />
									<col align="right" />
									<tr>
										<th>Efficiency</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
									<tr>
										<td>78</td>
										<td>69</td>
										<td>76</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-2.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/GithubVisualization/user/content?id=1615">John
									Resig</a>
								<p>
									Joined on 2008-02-28<br />email:jeresig@gmail.com<br />company:
									Khan Academy<br />Living in Brooklyn, NY
								</p>
								<br>
								<table border="1" width="100%">
									<col align="left" />
									<col align="left" />
									<col align="right" />
									<tr>
										<th>Efficiency</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
									<tr>
										<td>78</td>
										<td>69</td>
										<td>76</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-3.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/GithubVisualization/user/content?id=70">Scott
									Chacon</a>
								<p>
									Joined on 2008-01-17<br />email:schacon@gmail.com<br />company:
									GitHub <br />Living in San Francisco, CA
								</p>
								<br>
								<table border="1" width="100%">
									<col align="left" />
									<col align="left" />
									<col align="right" />
									<tr>
										<th>Efficiency</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
									<tr>
										<td>78</td>
										<td>69</td>
										<td>76</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-4.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/GithubVisualization/user/content?id=2741">David
									Heinemeier Hansson</a>
								<p>
									Joined on 2008-03-10<br />email:david@basecamp.com<br />company:
									Basecamp <br />Living in Chicago, USA
								</p>
								<br>
								<table border="1" width="100%">
									<col align="left" />
									<col align="left" />
									<col align="right" />
									<tr>
										<th>Efficiency</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
									<tr>
										<td>78</td>
										<td>69</td>
										<td>76</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Testimornial Area -->
	</div>

	<!-- Start Footer Area -->
	<footer id="footer-area">
		<div class="container">
			<div class="row text-center">
				<div class="col-sm-12">
					<div class="footer-content"></div>
				</div>
			</div>
		</div>
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-sm-12 text-center"></div>
			</div>
		</div>
	</footer>
	<!-- End Footer Area -->

	<script src="/visualize/js/jquery-1.11.2.min.js"></script>
	<script src="/visualize/js/jquery.scrollUp.min.js"></script>
	<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {

			// Parallax
			$('.intro-section').parallax({
				imageSrc : '/visualize/img/bg-1.jpg',
				speed : 0.2
			});
			$('.services-section').parallax({
				imageSrc : '/visualize/img/bg-2.jpg',
				speed : 0.2
			});
			
			// jQuery Scroll Up / Back To Top Image
			$.scrollUp({
				scrollName : 'scrollUp', // Element ID
				scrollDistance : 300, // Distance from top/bottom before showing element (px)
				scrollFrom : 'top', // 'top' or 'bottom'
				scrollSpeed : 1000, // Speed back to top (ms)
				easingType : 'linear', // Scroll to top easing (see http://easings.net/)
				animation : 'fade', // Fade, slide, none
				animationSpeed : 300, // Animation speed (ms)		        
				scrollText : '', // Text for element, can contain HTML		        
				scrollImg : true
			// Set true to use image		        
			});

			// ScrollUp Placement
			$(window).on(
					'scroll',
					function() {

						// If the height of the document less the height of the document is the same as the
						// distance the window has scrolled from the top...
						if ($(document).height() - $(window).height() === $(
								window).scrollTop()) {

							// Adjust the scrollUp image so that it's a few pixels above the footer
							$('#scrollUp').css('bottom', '80px');

						} else {
							// Otherwise, leave set it to its default value.
							$('#scrollUp').css('bottom', '30px');
						}
					});

			$('.single-page-nav').singlePageNav({
				offset : $('.single-page-nav').outerHeight(),
				speed : 1500,
				filter : ':not(.external)',
				updateHash : true
			});

			$('.navbar-toggle').click(function() {
				$('.single-page-nav').toggleClass('show');
			});

			$('.single-page-nav a').click(function() {
				$('.single-page-nav').removeClass('show');
			});

		});
	</script>
</body>
</html>