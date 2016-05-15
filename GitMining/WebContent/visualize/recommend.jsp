<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Recommend</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="/visualize/js/echarts.min.js"></script>
<script type="text/javascript" src="/visualize/js/chart/recommend.js"></script>
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
							<div class="radar" id="1stRadar">
								<script type="text/javascript">
									radar("1stRadar");
								</script>
							</div>
							<a class="First-Commend"
									href="http://www.gitmining.net/
							GithubVisualization/repository/content?id=8393">paperclip</a>
								<p class="feature-content-description">Easy file attachment
									management for ActiveRecord</p>
								<p>developer : thoughtbot</p>
								<p>Star : 144</p>
								<p>Fork : 222</p>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="2ndRadar">
								<script type="text/javascript">
									radar("2ndRadar");
								</script>
							</div>
							<a class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/repository/content?id=10865">friendly_id</a>
							<p class="feature-content-description">FriendlyId is the
								“Swiss Army bulldozer” of slugging and permalink plugins for
								ActiveRecord. It allows you to create pretty URL’s and work with
								human-friendly strings as if they were numeric ids for
								ActiveRecord models.</p>
							<p>developer : normanp</p>
							<p>Star : 3780</p>
							<p>Fork : 421</p>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="3rdRadar">
								<script type="text/javascript">
									radar("3rdRadar");
								</script>
							</div>
							 <a
								class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/repository/content?id=2376">acts_as_paranoid</a>
							<p class="feature-content-description">ActiveRecord plugin
								allowing you to hide and restore records without actually
								deleting them.</p>
							<p>developer : ActsAsParanoid</p>
							<p>Star : 144</p>
							<p>Fork : 222</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Feature Area -->
		
		<!-- Start feature Area -->
		<section id="feature-area" class="about-section">
			<div class="container">
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="4thRadar">
								<script type="text/javascript">
									radar("4thRadar");
								</script>
							</div>
							<a class="First-Commend"
									href="http://www.gitmining.net/
							GithubVisualization/repository/content?id=8393">paperclip</a>
								<p class="feature-content-description">Easy file attachment
									management for ActiveRecord</p>
								<p>developer : thoughtbot</p>
								<p>Star : 144</p>
								<p>Fork : 222</p>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="5thRadar">
								<script type="text/javascript">
									radar("5thRadar");
								</script>
							</div>
							<a class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/repository/content?id=10865">friendly_id</a>
							<p class="feature-content-description">FriendlyId is the
								“Swiss Army bulldozer” of slugging and permalink plugins for
								ActiveRecord. It allows you to create pretty URL’s and work with
								human-friendly strings as if they were numeric ids for
								ActiveRecord models.</p>
							<p>developer : normanp</p>
							<p>Star : 3780</p>
							<p>Fork : 421</p>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="feature-content">
							<div class="radar" id="6thRadar">
								<script type="text/javascript">
									radar("6thRadar");
								</script>
							</div>
							 <a
								class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/repository/content?id=2376">acts_as_paranoid</a>
							<p class="feature-content-description">ActiveRecord plugin
								allowing you to hide and restore records without actually
								deleting them.</p>
							<p>developer : ActsAsParanoid</p>
							<p>Star : 144</p>
							<p>Fork : 222</p>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End feature Area -->
	</div>
	
	<br/>
	<br/>
	
	<div id="section3">
		<!-- Start Services Area -->
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
								href="http://www.gitmining.net/
								GithubVisualization/user/content?id=2">Chris Wanstrath</a>
							<p>
								Joined on 2007-10-20<br />
								email: chris@github.com<br />
								company: GitHub<br />
								address: San Francisco<br />
							</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-2.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/user/content?id=39191">Paul Irish</a>
							<p>
								Joined on 2007-10-20<br />
								email: chris@github.com<br />
								company: GitHub<br />
								address: San Francisco<br />
							</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-3.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/user/content?id=66577">Jake Wharton</a>
							<p>
								Joined on 2007-10-20<br />
								email: chris@github.com<br />
								company: GitHub<br />
								address: San Francisco<br />
							</p>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
						<div class="testimonial-content">
							<img src="/visualize/img/4-4.jpg" alt="Image"> <a
								class="First-Commend"
								href="http://www.gitmining.net/
								GithubVisualization/user/content?id=1615">John Resig</a>
							<p>
								Joined on 2007-10-20<br />
								email: chris@github.com<br />
								company: GitHub<br />
								address: San Francisco<br />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="row text-center">
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-1.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/
									GithubVisualization/user/content?id=25254">TJ Holowaychuk</a>
								<p>
									star: 8000<br />
									fork: 8000<br />
									collaborator: 200<br />
									contributor: 200<br />
								</p>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-2.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/
									GithubVisualization/user/content?id=1615">John Resig</a>
								<p>
									star: 8000<br />
								fork: 8000<br />
									collaborator: 200<br />
									contributor: 200<br />
								</p>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-3.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/
									GithubVisualization/user/content?id=70">Scott Chacon</a>
								<p>
									star: 8000<br />
									fork: 8000<br />
									collaborator: 200<br />
									contributor: 200<br />
								</p>
							</div>
						</div>
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
							<div class="testimonial-content">
								<img src="/visualize/img/4-4.jpg" alt="Image"> <a
									class="First-Commend"
									href="http://www.gitmining.net/
									GithubVisualization/user/content?id=2741">David Heinemeier Hansson</a>
								<p>
									star: 8000<br />
									fork: 8000<br />
									collaborator: 200<br />
									contributor: 200<br />
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- End Testimornial Area -->
	</div>

	<%@include file="/visualize/common/footer.jsp" %>

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
		});
	</script>
</body>
</html>