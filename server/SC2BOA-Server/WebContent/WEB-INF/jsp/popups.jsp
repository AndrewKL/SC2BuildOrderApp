      
      <div class="sc2boaserver_popup" id="bootstrap_div">
      		<h1>Create Account</h1>
			<form:form name="createAccountForm" method="post" action="createAccount.do" commandName="user" >
				<spring:bind path="user">
					<c:if test="${not empty status.errorMessages}">
						<div class="error">
						<c:forEach var="error" items="${status.errorMessages}">
							Error: <c:out value="${error}" escapeXml="false"/><br/>
						</c:forEach>
						</div>
					</c:if>
				</spring:bind>
				<div class="popupFieldLabel">Username:</div>
				<div class="popupFieldInput"><form:input path="username"/></div>
				
				<div class="popupFieldLabel">Email:</div>
				<div class="popupFieldInput"><form:input path="email"/></div>
				
				<div class="popupFieldLabel">Password:</div>
				<div class="popupFieldInput"><form:password path="password"/></div>
				
				<div class="popupFieldLabel">Re-Type Password:</div>
				<div class="popupFieldInput"><input type="password" name="password2"/></div>
				
				<div class="popupSubmitButtons">
					<a class="saveButton" href="javascript:" onclick="document.createAccountForm.submit()">create account</a>
				</div>
				
				
			</form:form>
		</div>
		
      
      
	  
      <div id="login_div" class="sc2boaserver_popup">
      	<h1>Sign in</h1>
		<form action="j_spring_security_check" name="loginForm" method="post">
			<c:if test="${popupScreen!=null}">
				<div class="popupFieldLabel">
				<div class="error"><br/>Bad username/password</div>
				</div>
			</c:if>
			<div class="popupFieldLabel"><br/>Username:</div>
			<div class="popupFieldInput">
				<input name="j_username"/>
			</div>
			
			<div class="popupFieldLabel">Password:</div>
			<div class="popupFieldInput"><input type="password" name="j_password"/></div>
			
			<input type="hidden" value="on" name="_spring_security_remember_me" style="display: none"/>
			
			<div class="popupSubmitButtons">
				<a class="saveButton" href="javascript:" onclick="document.loginForm.submit()">sign in</a>
				<a class="cancelButton" href="javascript:" onclick="$.modal.close();">cancel</a>
			
			</div>
		</form>
      </div>
      
      <div id="manage_div" class="sc2boaserver_popup">
      	<form:form name="backupForm" action="backupRestore.do" onsubmit="return confirmBackupRestore()">
      	<h1>Backup/Restore Journal</h1>
      	
      	<div class="popupFieldLabel"><br/>Bucket:</div>
		<div class="popupFieldInput"><input name="backupBucket"/></div>
		
      	<div class="popupFieldLabel">Path:</div>
		<div class="popupFieldInput"><input name="backupPath"/></div>
		
		<div class="popupFieldLabel">
			<input type="radio" name="backupRestoreFlag" checked value="backup">&nbsp;Backup
			&nbsp;&nbsp;
			<input type="radio" name="backupRestoreFlag" value="restore">&nbsp;Restore
		</div>
		
		<div class="popupSubmitButtons">
			<a class="saveButton" href="javascript:" onclick="wait('manage_wait');document.backupForm.submit()">submit</a>
			<a class="cancelButton" href="javascript:" onclick="$.modal.close();">cancel</a>
			<img src="images/wait.gif" style="display: none; float: right" id="manage_wait"/>
		</div>      
      	</form:form>		
	  </div>