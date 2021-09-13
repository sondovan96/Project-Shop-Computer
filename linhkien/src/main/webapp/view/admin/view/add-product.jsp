<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Create New Product</title>
<!-- BOOTSTRAP STYLES-->
<link href="${url}/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${url}/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${url}/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/view/admin/view/nav-bar.jsp"></jsp:include>
		<!-- /. NAV TOP  -->
		<jsp:include page="/view/admin/view/slide-bar.jsp"></jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Create New Product</h2>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
						<div class="panel-heading">Add Product</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">
									<h3>Info Product:</h3>
										<form role="form" action="add" method="post"
											enctype="multipart/form-data">
											<div class="form-group">
												<label>Name</label>
												<div class="form-group">
													<input class="form-control"
														placeholder="Enter Product Name" name="name" />
												</div>

											</div>
											<div class="form-group">
												<label>Price</label>
												<div class="form-group">
													<input class="form-control" placeholder="Enter Price"
														type="number" name="price" />
												</div>
											</div>
											<div class="form-group">
												<label>Description</label>
												<div class="form-group">
													<textarea class="form-control" id="editor"
														placeholder="Enter Product Description" name="des" ></textarea>
												</div>
											</div>
											<div class="form-group">
												<label>Category</label>
												<div class="checkbox form-group">
													<select name="category">
														<c:forEach items="${categories}" var="c">
															<option value="${c.id}">${c.name}</option>
														</c:forEach>
													</select>
												</div>

											</div>
											<div class="form-group">
												<label>Image</label>
												<div class="form-group">
													<div class="form-group">
														<input type="file" class="form-control"
															name="image" >
													</div>
													
												</div>
											</div>
											<button type="submit" class="btn btn-primary">Add</button>
											<button type="reset" class="btn btn-warning">Reset</button>
										</form>


									</div>
								</div>
							</div>
						</div>
						<!-- End Form Elements -->
					</div>
				</div>
				<!-- /. ROW  -->
				
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${url}/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${url}/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${url}/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${url}/js/custom.js"></script>
	<script type="text/javascript" language="javascript">
		CKEDITOR.replace('editor', {
			width : '900px',
			height : '300px'
		});
	</script>

</body>
</html>