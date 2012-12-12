#version 120

attribute vec4 vPosition;
attribute float vlight;
attribute vec4 vNormal;
attribute vec2 vTexCoord;
attribute float vskylight;
attribute vec2 animation;

varying vec4 color;
varying vec4 normal;
varying vec2 uvcoord;

uniform mat4 Projection;
uniform mat4 View;
uniform mat4 Model;
		
void main()
{
	gl_Position = Projection * View  * Model * vPosition;
	
	uvcoord = vTexCoord + animation;
	color = vec4(vlight + vskylight,vlight + vskylight,vlight + vskylight, 1);
	normal = vNormal;
} 
